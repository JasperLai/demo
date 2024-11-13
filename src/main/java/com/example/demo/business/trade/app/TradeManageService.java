package com.example.demo.business.trade.app;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.business.customer.app.CustomerManageService;
import com.example.demo.business.customer.client.CustomerDTO;
import com.example.demo.business.customer.client.CustomerServiceInterface;
import com.example.demo.business.general.client.GeneralServiceInterface;
import com.example.demo.business.general.client.TMSInterface;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.general.client.TransactionVO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.business.product.app.dto.response.QuotaDTO;
import com.example.demo.business.product.client.ProductManageService;
import com.example.demo.business.product.domain.valueObject.BondVariety;
import com.example.demo.business.trade.app.dto.SubscribeDTO;

public class TradeManageService {

    @Autowired
    TMSInterface transactionService;

    @Autowired
    CustomerServiceInterface customerService;

    @Autowired
    ProductManageService productService;

    @Autowired
    private GeneralServiceInterface generalService;

    /**
     * 处理债券认购业务
     * 
     * @param subscribeDTO 认购请求数据传输对象
     * @param transactionVO 交易流水数据
     */
    public void processBondSubscribe(SubscribeDTO subscribeDTO, TransactionVO transactionVO) {
        
        // 生成交易流水号
        // 用于追踪整个交易过程，确保交易的唯一性和可追溯性
        String transactionNo = transactionService.createTransaction(transactionVO, TradeType.PURCHASE);

        // 上下文校验
        contextVerify(subscribeDTO);
    
        // 获取客户详细信息
        // 用于后续的业务处理和风控校验
        CustomerDTO customerDTO = customerService.getCustomer(subscribeDTO.getCustomerId());
        
        // 获取产品详细信息
        // 用于后续的产品相关验证和业务处理
        BondProductDTO productDTO = productService.queryProductDetail(subscribeDTO.getProductId());
        
        QuotaDTO quotaiton =  productService.getCurrentQuotation(subscribeDTO.getProductId());
        //本地验证
        // TradeRules.verify(subscribeDTO, customerDTO, productDTO, quotaiton);
        
        // // 业务逻辑开始
        // Purchase0rder order = OrderFactory.buildOrder(subscribeDTO,customerDTO,productDTO)

        // OrderRepository.save(order);

        // Order handledOrder = TradeServive.handle(order);

        // OrderRepository.update(order);

    }

    private void contextVerify(SubscribeDTO subscribeDTO){
        // 校验当前时间是否在营业时间内
        generalService.validateBusinessTime();
        // 检查客户账号和资金账号是否存在且状态正常，包括账户冻结状态，账户开户状态等
        customerService.verifyAccount(subscribeDTO.getCashAccountId());
        
        // 验证产品是否在分销期内
        productService.isUnderDistribution(subscribeDTO.getProductId());
        
        // 验证产品库存是否充足
        // 检查产品是否有足够的可用库存满足本次认购需求
        productService.checkInventory(subscribeDTO.getFaceAmount(), subscribeDTO.getProductId());
        
        productService.validateSaleArea(subscribeDTO.getProductId());
    }
    
   
 

}
