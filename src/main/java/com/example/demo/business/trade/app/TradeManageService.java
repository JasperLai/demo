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
        
       
    }
 

}
