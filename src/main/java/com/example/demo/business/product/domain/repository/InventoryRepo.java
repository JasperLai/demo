package com.example.demo.business.product.domain.repository;

import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.domain.repository.dto.ChangeQuoteDto;

public interface InventoryRepo {

    public Inventory queryInventory(ChangeQuoteDto dto);

    public void saveInventory(Inventory inventory);

}
