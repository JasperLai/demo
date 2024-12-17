package com.example.demo.business.trade.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.business.customer.client.CustomerDTO;
import com.example.demo.business.customer.client.CustomerServiceInterface;
import com.example.demo.business.general.client.CalendarInterface;
import com.example.demo.business.general.client.GeneralServiceInterface;
import com.example.demo.business.general.client.TMSInterface;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.general.app.dto.TransactionDTO;
import com.example.demo.business.product.app.dto.request.ProductValidateDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.business.product.client.ProductManageService;
import com.example.demo.business.trade.app.dto.TradeDTO;
import com.example.demo.business.trade.domain.entity.DistributionOrder;
import com.example.demo.business.trade.domain.service.TradeService;
import com.example.demo.common.catchall.CatchAndLog;

@Component
@CatchAndLog
public class TradeManageService {

    @Autowired
    TMSInterface transactionService;

    @Autowired
    CustomerServiceInterface customerService;

    @Autowired
    ProductManageService productService;

    @Autowired
    private GeneralServiceInterface generalService;

    @Autowired
    private CalendarInterface calendarService;

    @Autowired
    private TradeService tradeService;

    /**
     * 处理债券认购业务
     * 
     * @param tradeDTO       交易请求数据传输对象
     * @param transactionDTO 交易流水数据
     * @return 交易流水号
     */
    @Transactional
    public void processBondSubscription(TradeDTO tradeDTO, TransactionDTO transactionDTO) {

        TradeType currTradeType = TradeType.DISTRIBUTION;

        String transID = transactionService.createTransaction(transactionDTO, currTradeType);

        BondProductDTO productInfo = productService.validateOrder(createProductValidateDTO(tradeDTO, currTradeType));

        CustomerDTO customerInfo = customerService.getCustomer(tradeDTO.getBPNumber());

        calendarService.checkTradeTime(currTradeType);

        DistributionOrder order = new DistributionOrder();
        
        tradeService.initializeOrder(order, tradeDTO, transID, 
            productInfo.getBondCode(),     // 债券代码
            customerInfo.getTradeAcc());
        
        tradeService.processOrder(order);
    }

    

    private ProductValidateDTO createProductValidateDTO(TradeDTO tradeDTO, TradeType currTradeType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProductValidateDTO'");
    }
}
