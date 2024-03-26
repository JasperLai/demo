package com.example.demo.business.trade.client;

import java.util.Date;

public interface AccountingManageService {

    //对账
    void reconciliation(Date date);

    //核销
    void writeOff(String condition, Date date, String peOrderId);
}
