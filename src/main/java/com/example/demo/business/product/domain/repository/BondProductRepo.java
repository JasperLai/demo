package com.example.demo.business.product.domain.repository;

import com.example.demo.business.product.domain.domainObject.Bond;

public interface BondProductRepo {

    public void updateLimit(long upperLimit, long lowerLimit);
    
    public boolean registBond(Bond bondinfo);

    public void updateProduct();


}
