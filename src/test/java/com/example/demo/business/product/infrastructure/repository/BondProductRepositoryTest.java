package com.example.demo.business.product.infrastructure.repository;

import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondBusinessAuth;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import com.example.demo.business.product.domain.valueObject.BondVariety;
import com.example.demo.business.product.domain.valueObject.AccrualBase;
import com.example.demo.business.product.domain.valueObject.AccrualMethod;
import com.example.demo.business.product.domain.valueObject.CustodyOrg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class BondProductRepositoryTest {

    @Autowired
    private BondProductRepository bondProductRepository;

    @Test
    void should_save_and_update_bond_product() {
        // given - 创建测试数据
        BondProduct bondProduct = createTestBondProduct();

        // when - 保存数据
        bondProductRepository.saveProduct(bondProduct);

        // then - 验证更新
        bondProduct.setSaleArea("330000");  // 修改为浙江省
        bondProduct.setSellableCustomerType("02");  // 修改客户类型
        bondProductRepository.updateProduct(bondProduct);
    }

    private BondProduct createTestBondProduct() {
        // 创建债券信息
        Bond bond = new Bond();
        bond.setBondCode("019666");  // 示例国债代码
        
        // 创建业务权限
        BondBusinessAuth authority = new BondBusinessAuth();
        authority.enableAllTransactions();
        authority.enable(BondBusinessAuth.TransactionType.BUY_SELL);
        authority.enable(BondBusinessAuth.TransactionType.TRANSFER);
        authority.setBondCode("019666");

        // 构建产品信息，确保 FDM_PRODUCT_CODE 长度不超过64
        return BondProduct.builder()
                .withProductCode("152029001")
                .withFDMCode("FDM019666")    // 使用简短的FDM编码
                .withBond(bond)
                .withAuthority(authority)
                .withSaleArea("320000")      // 江苏省
                .withSellableCustomerType("01") // 个人客户
                .build();
    }

    private Bond createTestBond() {
        Bond bond = new Bond();
        
        // 必填字段(根据数据库NOT NULL约束)
        bond.setBondCode("240001");  // 债券代码
        bond.setShortName("24国债01"); // 债券简称
        bond.setVariety(BondVariety.fromCode("GB03")); // 债券品种:国债
        bond.setBondTerm(10); // 债券期限
        bond.setBondTermUnit("0"); // 期限单位:年
        bond.setIssuePrice(new BigDecimal("100.000")); // 发行价格
        bond.setCoupon(new BigDecimal("2.85000")); // 票面利率
        bond.setCurrency("CNY"); // 币种
        
        // 设置日期字段
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 10); // 2022-01-10
        Date issueDate = calendar.getTime();
        bond.setIssueDate(issueDate); // 发行日
        
        // 设置分销开始日（发行日当天）
        bond.setDistStartDate(issueDate); // 分销开始日:2022-01-10
        
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        bond.setAccrualDate(calendar.getTime()); // 起息日:2022-01-11
        
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        bond.setIssueEndDate(calendar.getTime()); // 发行结束日:2022-01-12
        
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        bond.setListingDate(calendar.getTime()); // 上市日:2022-01-13
        
        // 设置到期日(10年后)
        calendar.setTime(issueDate);
        calendar.add(Calendar.YEAR, 10);
        bond.setMatureDate(calendar.getTime()); // 到期日:2032-01-10
        
        // 设置第一次付息日(6个月后)
        calendar.setTime(issueDate);
        calendar.add(Calendar.MONTH, 6);
        bond.setFirstInterestPaymentDate(calendar.getTime()); // 第一次付息日:2022-07-10
        bond.setInterestPaymentDate(bond.getFirstInterestPaymentDate()); // 本计息期付息日
        
        // 设置其他必填字段
        bond.setAccrualBase(AccrualBase.fromCode(3)); // 计息基础
        bond.setAccrualMethod(AccrualMethod.fromCode("10")); // 计息方式
        bond.setParValue(100); // 面值
        bond.setCustodyOrg(CustodyOrg.fromCode("中债登")); // 托管机构
        bond.setBondStatus("1"); // 债券状态:正常
        bond.setBondPauseStatus("1"); // 暂停状态:正常
        bond.setAddTimes(0); // 追加次数
        
        // 设置其他日期字段
        calendar.setTime(issueDate);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        bond.setBondRegistrationDate(calendar.getTime()); // 债权登记日:2022-01-09
        
        // 设置截止过户日（付息日前一天）
        calendar.setTime(bond.getFirstInterestPaymentDate());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        bond.setCutoffTransferDate(calendar.getTime()); // 截止过户日:2022-07-09
        
        bond.setPrincipalValueEffectiveDate(issueDate); // 本金值生效日
        bond.setBusinessDate(new Date()); // 业务日期设为当前日期
        
        // 设置付息相关
        bond.setInterestPaymentCycle("6"); // 半年付息
        bond.setTransferPauseDayBeforeCash(1); // 付息前1天停止转托管
        
        return bond;
    }

    @Test
    void should_save_bond() {
        // Given
        Bond bond = createTestBond();

        // When
        bondProductRepository.saveBond(bond);

        // Then
        Bond savedBond = bondProductRepository.findBondByBondCode(bond.getBondCode());
        assertThat(savedBond).isNotNull();
        assertThat(savedBond.getBondCode()).isEqualTo(bond.getBondCode());
        assertThat(savedBond.getShortName()).isEqualTo(bond.getShortName());
        assertThat(savedBond.getCoupon()).isEqualByComparingTo(bond.getCoupon());
    }

    @Test
    void should_update_bond() {
        // Given
        Bond bond = createTestBond();
        bondProductRepository.saveBond(bond);

        // When
        bond.setShortName("更新后的测试债券");
        bond.setCoupon(new BigDecimal("4.0"));
        bondProductRepository.updateBond(bond);

        // Then
        Bond updatedBond = bondProductRepository.findBondByBondCode(bond.getBondCode());
        assertThat(updatedBond).isNotNull();
        assertThat(updatedBond.getShortName()).isEqualTo("更新后的测试债券");
        assertThat(updatedBond.getCoupon()).isEqualByComparingTo(new BigDecimal("4.0"));
    }

    @Test
    void should_find_bond_by_bond_code() {
        // Given
        Bond bond = createTestBond();
        bondProductRepository.saveBond(bond);

        // When
        Bond foundBond = bondProductRepository.findBondByBondCode(bond.getBondCode());

        // Then
        assertThat(foundBond).isNotNull();
        assertThat(foundBond.getBondCode()).isEqualTo(bond.getBondCode());
        assertThat(foundBond.getShortName()).isEqualTo(bond.getShortName());
        assertThat(foundBond.getVariety()).isEqualTo(bond.getVariety());
        assertThat(foundBond.getCoupon()).isEqualByComparingTo(bond.getCoupon());
    }

    @Test
    void should_find_all_bonds() {
        // Given
        Bond bond1 = createTestBond();
        Bond bond2 = createTestBond();
        bond2.setBondCode("TEST002");
        bond2.setShortName("测试债券2");

        bondProductRepository.saveBond(bond1);
        bondProductRepository.saveBond(bond2);

        // When
        List<Bond> bonds = bondProductRepository.findAllBonds();

        // Then
        assertThat(bonds).isNotNull();
        assertThat(bonds).extracting(Bond::getBondCode)
                .contains(bond1.getBondCode(), bond2.getBondCode());
    }

    @Test
    void should_save_bond_with_duplicate_key() {
        // Given
        Bond originalBond = createTestBond();
        bondProductRepository.saveBond(originalBond);

        // When
        Bond updatedBond = createTestBond();
        updatedBond.setShortName("重复插入更新");
        updatedBond.setCoupon(new BigDecimal("5.0"));
        bondProductRepository.saveBond(updatedBond);

        // Then
        Bond result = bondProductRepository.findBondByBondCode(originalBond.getBondCode());
        assertThat(result).isNotNull();
        assertThat(result.getShortName()).isEqualTo("重复插入更新");
        assertThat(result.getCoupon()).isEqualByComparingTo(new BigDecimal("5.0"));
    }
} 