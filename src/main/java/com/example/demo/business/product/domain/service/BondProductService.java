package com.example.demo.business.product.domain.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.business.product.domain.domainObject.Bond;
import com.example.demo.business.product.domain.domainObject.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepo;
import com.example.demo.business.product.domain.repository.dto.BondInfoDto;
import com.example.demo.business.product.domain.valueObject.BondLifeCycle;

public class BondProductService {
    private static final Logger logger = LogManager.getLogger(BondProductService.class);

    @Autowired
    private BondProductRepo repo;

    /**
     * TODO 查询债券详情
     * @param bondCode
     * @return
     */
    public Bond getBondDetailInfo(String bondCode){
        return null;
    }

    /**
     * TODO 债券注册
     * @param bondinfoDto 债券注册参数
     * @return
     */
    public boolean registBond(BondInfoDto bondinfo){
        return false;
    }

    /**
     * TODO 产品查询
     * @param bondCode 债券代码，非必输
     * @param lifeCycle 债券生命周期，非必输
     */
    public List<BondProduct> getProduct(String bondCode, BondLifeCycle lifeCycle){
        return null;
    }

}
