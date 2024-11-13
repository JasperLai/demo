package com.example.demo.business.general.app;

import com.example.demo.business.general.client.TMSInterface;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.general.client.TransStatus;
import com.example.demo.business.general.client.TransactionVO;
import com.example.demo.business.general.app.dto.TransactionDTO;

public class TransactionManageService implements TMSInterface{

    @Override
    public String createTransaction(TransactionVO vo, TradeType type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTransaction'");
    }

    @Override
    public TransactionDTO query(String transactionNo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
            }

    @Override
    public boolean updateTransaction(String transactonID, TransStatus s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTransaction'");
    }

}
