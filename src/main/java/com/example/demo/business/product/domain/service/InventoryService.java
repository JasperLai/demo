package com.example.demo.business.product.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.business.product.domain.entity.Inventory;
import com.example.demo.business.product.domain.repository.InventoryRepository;
import com.example.demo.common.catchall.CatchAndLog;

@Component
@CatchAndLog
public class InventoryService {
    
    @Autowired
    private InventoryRepository inventoryRepository;
    
    /**
     * 执行库存额度调拨的核心业务逻辑
     */
    @Transactional
    public void transferInventory(Inventory outInventory, Inventory inInventory, long amount) {
        if (outInventory == null || inInventory == null || amount <= 0) {
            throw new IllegalArgumentException("调拨参数不合法");
        }
        
        if (outInventory.getLimits() < amount) {
            throw new IllegalArgumentException("调出机构可用额度不足");
        }
        
        // 更新源机构库存
        outInventory.setLimits(outInventory.getLimits() - amount);
        inventoryRepository.update(outInventory);
        
        // 更新目标机构库存
        inInventory.setLimits(inInventory.getLimits() + amount);
        inventoryRepository.update(inInventory);
    }
}

