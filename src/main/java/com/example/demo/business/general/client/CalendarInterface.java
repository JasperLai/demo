package com.example.demo.business.general.client;

import java.time.LocalDate;

public interface CalendarInterface {

    public boolean isWorkDay(LocalDate date);

    public void checkTradeTime(TradeType type);

}
