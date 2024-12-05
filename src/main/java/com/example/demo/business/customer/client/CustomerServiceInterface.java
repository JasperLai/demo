package com.example.demo.business.customer.client;

import com.example.demo.business.general.app.dto.TransactionDTO;

public interface CustomerServiceInterface {

    //获取客户信息
    CustomerDTO getCustomer(String customerId);

    //验证账户
    void verifyAccount(String cashAccountId);

    //开户
    void openAccount(OpenAccountDTO openAccountDTO, TransactionDTO trans);

    //销户
    void cancelAccount(CancelAccountDTO cancelAccountDTO, TransactionDTO trans);

}  
