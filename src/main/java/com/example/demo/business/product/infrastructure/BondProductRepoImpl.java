package com.example.demo.business.product.infrastructure;

import org.springframework.stereotype.Repository;

import com.example.demo.business.product.domain.domainObject.Bond;
import com.example.demo.business.product.domain.domainObject.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepo;
@Repository
public class BondProductRepoImpl implements BondProductRepo {

    @Override
    public void updateLimit(long upperLimit, long lowerLimit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateLimit'");
    }

    @Override
    public boolean registBond(Bond bondinfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registBond'");
    }

    @Override
    public void updateProduct(BondProduct p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public void updateAuth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAuth'");
    }

}
