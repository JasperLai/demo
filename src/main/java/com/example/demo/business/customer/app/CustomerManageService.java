package com.example.demo.business.customer.app;


import com.example.demo.business.customer.client.CancelAccountDTO;
import com.example.demo.business.customer.client.CustomerDTO;
import com.example.demo.business.customer.client.CustomerServiceInterface;
import com.example.demo.business.customer.client.OpenAccountDTO;
import com.example.demo.business.general.app.dto.TransactionDTO;

public class CustomerManageService implements CustomerServiceInterface{

    @Override
    public CustomerDTO getCustomer(String customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomer'");
    }

    @Override
    public void verifyAccount(String cashAccountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyAccount'");
    }


    @Override
    public void openAccount(OpenAccountDTO openAccountDTO, TransactionDTO trans) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'openAccount'");
    }

    @Override
    public void cancelAccount(CancelAccountDTO cancelAccountDTO, TransactionDTO trans) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelAccount'");
    }
}
    