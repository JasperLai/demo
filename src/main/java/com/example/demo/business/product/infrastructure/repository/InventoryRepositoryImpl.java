package com.example.demo.business.product.infrastructure.repository;

import com.example.demo.business.product.domain.entity.Inventory;
import com.example.demo.business.product.domain.repository.InventoryRepository;
import com.example.demo.business.product.infrastructure.mapper.InventoryMapper;
import com.example.demo.business.product.app.dto.response.InventoryDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class InventoryRepositoryImpl implements InventoryRepository {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    @Transactional
    public void save(Inventory inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null");
        }
        InventoryDTO dto = InventoryDTO.fromEntity(inventory);
        inventoryMapper.insert(dto);
    }

    @Override
    @Transactional
    public void update(Inventory inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null");
        }
        InventoryDTO dto = InventoryDTO.fromEntity(inventory);
        inventoryMapper.update(dto);
    }

    @Override
    public Inventory findByProductIdAndOrgNum(String productId, String orgNum) {
        if (productId == null || orgNum == null) {
            throw new IllegalArgumentException("ProductId and OrgNum cannot be null");
        }
        InventoryDTO dto = inventoryMapper.selectByProductIdAndOrgNum(productId, orgNum);
        return dto != null ? dto.toEntity() : null;
    }

    @Override
    public List<Inventory> findByProductId(String productId) {
        if (productId == null) {
            throw new IllegalArgumentException("ProductId cannot be null");
        }
        List<InventoryDTO> dtos = inventoryMapper.selectByProductId(productId);
        return dtos.stream()
                .map(InventoryDTO::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Inventory> findByOrgNum(String orgNum) {
        if (orgNum == null) {
            throw new IllegalArgumentException("OrgNum cannot be null");
        }
        List<InventoryDTO> dtos = inventoryMapper.selectByOrgNum(orgNum);
        return dtos.stream()
                .map(InventoryDTO::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Inventory> findAll() {
        List<InventoryDTO> dtos = inventoryMapper.selectAll();
        return dtos.stream()
                .map(InventoryDTO::toEntity)
                .collect(Collectors.toList());
    }
} 