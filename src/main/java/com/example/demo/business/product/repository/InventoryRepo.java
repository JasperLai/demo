package com.example.demo.business.product.repository;

import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.repository.dto.ChangeQuotationDto;

public interface InventoryRepo {

    public Inventory queryInventory(ChangeQuotationDto dto);

    public void saveInventory(Inventory inventory);

}
