package com.example.demo.business.trade.app;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.business.customer.client.CustomerServiceInterface;
import com.example.demo.business.general.client.GeneralServiceInterface;
import com.example.demo.business.general.client.TMSInterface;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.general.app.dto.TransactionDTO;
import com.example.demo.business.product.client.ProductManageService;
import com.example.demo.business.trade.app.dto.TradeDTO;

@Service
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
     * @param tradeDTO 交易请求数据传输对象
     * @param transactionDTO 交易流水数据
     * @return 交易流水号
     */
    @Transactional
    public String processBondSubscribe(TradeDTO tradeDTO, TransactionDTO transactionDTO) {
        // 1. 补充交易流水基础信息
        if (transactionDTO.getBusinessDate() == null) {
            transactionDTO.setBusinessDate(LocalDate.now());
        }
        if (transactionDTO.getTradeTime() == null) {
            transactionDTO.setTradeTime(LocalDateTime.now());
        }
        
        // 2. 设置交易账号（从交易DTO中获取）
        transactionDTO.setTradeAcc(tradeDTO.getCustomerId());
        
        // 3. 创建交易流水
        String txTraceNum = transactionService.createTransaction(transactionDTO, TradeType.DISTRIBUTION);
        
        // TODO: 后续业务处理
        // 4. 校验客户信息
        // 5. 校验产品信息
        // 6. 创建订单
        // 7. 登记账务
        
        return txTraceNum;
    }
}
