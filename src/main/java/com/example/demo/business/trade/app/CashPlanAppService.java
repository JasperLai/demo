package com.example.demo.business.trade.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.business.customer.client.CustomerPositionService;
import com.example.demo.business.customer.client.dto.CustomerPositionDTO;
import com.example.demo.business.product.client.ProductManageService;
import com.example.demo.business.product.app.dto.response.BondDTO;
import com.example.demo.business.trade.domain.entity.CashPlan;
import com.example.demo.business.trade.domain.service.CashPlanDomainService;
import com.example.demo.business.trade.domain.valueobject.CashPlanStatus;
import com.example.demo.business.trade.domain.valueobject.CashType;

@Service
public class CashPlanAppService {

    @Autowired
    private ProductManageService productManageService;

    @Autowired
    private CustomerPositionService customerPositionService;

    @Autowired
    private CashPlanDomainService cashPlanDomainService;

    /**
     * 生成债权登记日的付息兑付计划
     */
    @Transactional
    public void generateRegistrationDateCashPlans() {
        // 1. 获取处于债权登记日的债券
        List<BondDTO> registrationBonds = productManageService.queryBondsInRegistrationDate();
        if (registrationBonds.isEmpty()) {
            return;
        }

        // 2. 获取这些债券的客户持仓信息
        List<String> bondCodes = registrationBonds.stream()
                .map(BondDTO::getBondCode)
                .collect(Collectors.toList());
        
        List<CustomerPositionDTO> positions = customerPositionService.queryCustomerPositions(bondCodes);
        if (positions.isEmpty()) {
            return;
        }

        // 3. 按债券代码分组持仓信息
        Map<String, List<CustomerPositionDTO>> positionMap = positions.stream()
                .collect(Collectors.groupingBy(CustomerPositionDTO::getBondCode));

        // 4. 生成付息兑付计划
        List<CashPlan> cashPlans = new ArrayList<>();
        
        for (BondDTO bond : registrationBonds) {
            List<CustomerPositionDTO> bondPositions = positionMap.get(bond.getBondCode());
            if (bondPositions == null || bondPositions.isEmpty()) {
                continue;
            }

            // 为每个持有该债券的客户生成付息计划
            for (CustomerPositionDTO position : bondPositions) {
                CashPlan cashPlan = createCashPlan(bond, position);
                cashPlans.add(cashPlan);
            }
        }

        // 5. 批量保存付息兑付计划
        if (!cashPlans.isEmpty()) {
            cashPlanDomainService.createCashPlans(cashPlans);
        }
    }

    /**
     * 根据债券和持仓信息创建付息兑付计划
     */
    private CashPlan createCashPlan(BondDTO bond, CustomerPositionDTO position) {
        CashPlan cashPlan = new CashPlan();
        
        // 设置基本信息
        cashPlan.setTradeAcc(position.getCustomerId());
        cashPlan.setBondCode(bond.getBondCode());
        cashPlan.setCaptAcc(position.getCaptAcc());
        
        // 设置付息日期（下一付息日）
        cashPlan.setWorkDate(LocalDate.from(bond.getInterestPaymentDate().toInstant()));
        
        // 计算付息金额：持仓面额 * 票面利率
        BigDecimal amount = position.getFaceAmount()
                .multiply(bond.getCoupon())
                .divide(BigDecimal.valueOf(100)); // 票面利率是百分比
        cashPlan.setAmount(amount);
        
        // 设置付款类型和状态
        cashPlan.setCashType(CashType.INTEREST);  // 付息
        cashPlan.setStatus(CashPlanStatus.PENDING);
        
        // 设置备注
        cashPlan.setRemark("债权登记日付息计划");
        
        return cashPlan;
    }
} 