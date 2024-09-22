package com.example.demo.business.general.client;

import com.example.demo.business.general.app.dto.TransactionDTO;

/**
 * 统一流水登记
 */
public interface TMSInterface {

    /**
     * create transaction
     * @param vo trans info
     * @param type  trade type
     * @return  transaction no.
     */
    public String createTransaction(TransactionVO vo, TradeType type);

    public TransactionDTO query(String transactionNo);

    public boolean updateTransaction(String transactonID, TransStatus s);


}
