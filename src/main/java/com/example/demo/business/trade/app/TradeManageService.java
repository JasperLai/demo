package com.example.demo.business.trade.app;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.business.customer.client.CustomerServiceInterface;
import com.example.demo.business.general.client.GeneralServiceInterface;
import com.example.demo.business.general.client.TMSInterface;
import com.example.demo.business.general.app.dto.TransactionDTO;
import com.example.demo.business.product.client.ProductManageService;
import com.example.demo.business.trade.app.dto.TradeDTO;

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
     */
    public void processBondSubscribe(TradeDTO tradeDTO, TransactionDTO transactionDTO) {
        
    }
 

}
