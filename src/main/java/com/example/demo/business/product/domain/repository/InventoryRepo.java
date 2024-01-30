package com.example.demo.business.product.domain.repository;

import com.example.demo.business.product.app.request.ChangeQuoteDto;
import com.example.demo.business.product.domain.domainObject.Inventory;

public interface InventoryRepo {

    public Inventory queryInventory(ChangeQuoteDto dto);

    public void saveInventory(Inventory inventory);

}
