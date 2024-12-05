package com.example.demo.business.product.domain.repository;

import com.example.demo.business.product.domain.entity.Inventory;
import java.util.List;

public interface InventoryRepository {
    void save(Inventory inventory);
    
    void update(Inventory inventory);
    
    Inventory findByProductIdAndOrgNum(String productId, String orgNum);
    
    List<Inventory> findByProductId(String productId);
    
    List<Inventory> findByOrgNum(String orgNum);
    
    List<Inventory> findAll();
}
