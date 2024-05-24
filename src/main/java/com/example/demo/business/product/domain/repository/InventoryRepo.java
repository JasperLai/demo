package com.example.demo.business.product.domain.repository;

import org.springframework.stereotype.Component;

import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.domain.domainObject.Inventory.SaleStrategy;
@Component
public interface InventoryRepo {


    public void saveInventory(Inventory inventory);

    public Inventory findByOrgId(String orgId);

    //  public static Inventory findByOrgId(String orgId) {
    //     // This method would interact with the database to retrieve an Inventory instance
    //     // Placeholder implementation
    //     return new Inventory(orgId, "bondCode", SaleStrategy.SPECIFIC); // Example return value
    // }

}
