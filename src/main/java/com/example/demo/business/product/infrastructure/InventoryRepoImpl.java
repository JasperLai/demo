package com.example.demo.business.product.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.business.product.domain.repository.InventoryRepo;
import com.example.demo.business.product.domain.repository.dto.InventoryDTO;
import com.example.demo.business.product.infrastructure.mapper.InventoryMapper;

@Repository
public class InventoryRepoImpl implements InventoryRepo{


    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public void saveInventory(InventoryDTO inventory) {
        // TODO Auto-generated method stub
        inventoryMapper.insert(inventory);
    }

    @Override
    public InventoryDTO findByOrgId(String orgId) {
        // TODO Auto-generated method stub
        InventoryDTO inventory = inventoryMapper.findByOrgId(orgId);
        return inventory;

    }

    @Override
    public InventoryDTO findByBondCode(String bondCode) {
        // TODO Auto-generated method stub
        InventoryDTO inventory = inventoryMapper.findByBondCode(bondCode);
        return inventory;
    }



  

}