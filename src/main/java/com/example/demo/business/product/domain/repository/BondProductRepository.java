package com.example.demo.business.product.domain.repository;

import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondProduct;
import java.util.List;

public interface BondProductRepository {

    
    public void saveProduct(BondProduct p);

    public void updateProduct(BondProduct p);

    /**
     * 根据ID查询债券产品
     * @param id 产品ID
     * @return 债券产品
     */
    BondProduct findByProductId(String productId);
    
    /**
     * 查询所有债券产品
     * @return 债券产品列表
     */
    List<BondProduct> findAll();

    public void saveBond(Bond bond);

    public void updateBond(Bond bond);

    public Bond findBondByBondCode(String bondCode);

    public List<Bond> findAllBonds();


}
