package com.example.demo.business.product.domain.repository;

import org.springframework.stereotype.Component;

import com.example.demo.business.product.domain.repository.dto.InventoryDTO;
@Component
public interface InventoryRepo {


    public void saveInventory(InventoryDTO inventory);

    public InventoryDTO findByOrgId(String orgId);

    public InventoryDTO findByBondCode(String bondCode);


    //  public static Inventory findByOrgId(String orgId) {
    //     // This method would interact with the database to retrieve an Inventory instance
    //     // Placeholder implementation
    //     return new Inventory(orgId, "bondCode", SaleStrategy.SPECIFIC); // Example return value
    // }

}
