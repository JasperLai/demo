package com.example.demo.business.product.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import com.example.demo.common.catchall.CatchAndLog;
@Component
@CatchAndLog
public class BondProductService {

    // Injecting the ProductRepo dependency
    @Autowired
    private BondProductRepository repository;

    public void mergeReissueProduct(String bondCode) {
        // Business logic for merging a reissued bond product
        // Use the injected repository to perform the necessary database actions
        System.out.println("Merging reissued bond product with code: " + bondCode);
        // Actual implementation goes here
    }

    public void addProduct(BondProduct product, boolean isReissue) {
        // Business logic for adding a bond product
        System.out.println("Adding product: " + product + " Is reissue: " + isReissue);
        // Further logic depending on whether it is a reissue or not
        if (isReissue) {
            // Handle reissue-specific logic
        }
    }
}
