package com.example.demo.business.product.domain.repository;

import com.example.demo.business.product.domain.domainObject.Bond;
import com.example.demo.business.product.domain.domainObject.BondProduct;

public interface BondProductRepo {

    public void updateLimit(long upperLimit, long lowerLimit);
    
    public boolean registBond(Bond bondinfo);

    public void updateProduct(BondProduct p);

    //产品权限更新
    public void updateAuth();


}
