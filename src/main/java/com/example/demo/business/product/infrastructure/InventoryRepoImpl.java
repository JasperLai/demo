package com.example.demo.business.product.infrastructure;

import org.springframework.stereotype.Repository;

import com.example.demo.business.product.adapter.request.ChangeQuoteDto;
import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.domain.repository.InventoryRepo;

@Repository
public class InventoryRepoImpl implements InventoryRepo{

    @Override
    public Inventory queryInventory(ChangeQuoteDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryInventory'");
    }

    @Override
    public void saveInventory(Inventory inventory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveInventory'");
    }

    @Override
    public Inventory findByOrgId(String orgId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByOrgId'");
    }

}
