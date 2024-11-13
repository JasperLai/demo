package com.example.demo.business.customer.client;

public interface CustomerServiceInterface {

    CustomerDTO getCustomer(String customerId);

    void verifyAccount(String cashAccountId);

    
}  
