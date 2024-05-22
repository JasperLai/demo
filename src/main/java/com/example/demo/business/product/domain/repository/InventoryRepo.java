package com.example.demo.business.product.domain.repository;

import com.example.demo.business.product.app.request.ChangeQuoteDto;
import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.domain.domainObject.Inventory.SaleStrategy;

public interface InventoryRepo {

    public Inventory queryInventory(ChangeQuoteDto dto);

    public void saveInventory(Inventory inventory);

    public Inventory findByOrgId(String orgId);

    //  public static Inventory findByOrgId(String orgId) {
    //     // This method would interact with the database to retrieve an Inventory instance
    //     // Placeholder implementation
    //     return new Inventory(orgId, "bondCode", SaleStrategy.SPECIFIC); // Example return value
    // }

}
