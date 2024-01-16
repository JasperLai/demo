package com.example.demo.business.product.domain.domainObject;

import java.math.BigDecimal;
import java.util.Date;

public class BondQuotation {

    private String bondCode;
    private BigDecimal bankBuyNetPrice;
    private BigDecimal bankSellNetPrice;
    private BigDecimal accruedInterest;
    private int quotationType; //1 手工 0 自动
    private Date quotationDate ;//报价日期 需要使用canlendar 类

    public BigDecimal getBankBuyFullPrice(){
        
        return bankBuyNetPrice.add(accruedInterest);
    }

    public BigDecimal getBankSellFullPrice(){
        
        return bankSellNetPrice.add(accruedInterest);
    }

}
