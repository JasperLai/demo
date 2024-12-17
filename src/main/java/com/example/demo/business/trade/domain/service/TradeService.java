package com.example.demo.business.trade.domain.service;

import com.example.demo.business.trade.app.dto.TradeDTO;
import com.example.demo.business.trade.domain.entity.Order;
import java.math.BigDecimal;
import java.util.Date;

public class TradeService {

    public void initializeOrder(Order order, TradeDTO tradeDTO, String transID, String productCode, String tradeAcc) {
        // 设置通用属性
        order.setTxTraceNum(transID);
        order.setProductId(productCode);
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
}
