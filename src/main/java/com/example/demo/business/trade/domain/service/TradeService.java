package com.example.demo.business.trade.domain.service;

import com.example.demo.business.customer.client.CustomerDTO;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.trade.app.dto.TradeDTO;
import com.example.demo.business.trade.domain.entity.DistributionOrder;
import com.example.demo.business.trade.domain.entity.Order;
import com.example.demo.business.trade.domain.entity.SpotBuyOrder;
import com.example.demo.business.trade.domain.entity.SpotSellOrder;
import com.example.demo.business.trade.domain.facade.CCDCFacade;
import com.example.demo.business.trade.domain.facade.PaymentFacade;
import com.example.demo.business.trade.domain.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TradeService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderProcessor orderProcessor;

    @Autowired
    private PaymentFacade paymentFacade;

    @Autowired
    private CCDCFacade CCDCFacade;
    
    private Order convertToSpecificOrder(Order baseOrder) {
        TradeType tradeType = TradeType.getByCode(baseOrder.getTxCode());
        switch(tradeType) {
            case DISTRIBUTION:
                return new DistributionOrder(baseOrder);
            case BANK_BUY:
                return new SpotBuyOrder(baseOrder);
            case BANK_SELL:
                return new SpotSellOrder(baseOrder);
            default:
                throw new IllegalArgumentException("Unknown trade type: " + baseOrder.getTxCode());
        }
    }

   

    public Order getOrder(String txTraceNum) {
        Order baseOrder = orderRepository.findByTxTraceNum(txTraceNum);
        return convertToSpecificOrder(baseOrder);
    }

    public List<Order> getOrdersByTradeAcc(String tradeAcc) {
        List<Order> baseOrders = orderRepository.findByTradeAcc(tradeAcc);
        return baseOrders.stream()
                .map(this::convertToSpecificOrder)
                .collect(Collectors.toList());
    }

    public void initializeOrder(Order order, TradeDTO tradeDTO, String transID, String bondCode, String tradeAcc) {
        order.setTxTraceNum(transID);
        order.setProductId(tradeDTO.getProductId());
        order.setBondCode(bondCode);
        order.setTradeAcc(tradeAcc);
        // 计算交易金额：份额 * 100 * 价格
        BigDecimal quantity = new BigDecimal(tradeDTO.getQuantity());
        BigDecimal price = tradeDTO.getDirtyPrice();
        BigDecimal txMnt = quantity.multiply(BigDecimal.valueOf(100)).multiply(price);
        
        order.setTxMnt(txMnt);
        order.setTxQuantity(tradeDTO.getQuantity());
        order.setTxDt(new Date());
        order.setTxIn(new Date());
    }

    public void processOrder(Order order) {
        order.process(orderProcessor);
    }

    public void fundEncashment(BigDecimal amount, CustomerDTO customer){
        // paymentFacade.fundEncashment(amount, customer);
    }

    public void reportCCDC(Order order, CustomerDTO customer){
        CCDCFacade.distributeReport(order);
    }
}
