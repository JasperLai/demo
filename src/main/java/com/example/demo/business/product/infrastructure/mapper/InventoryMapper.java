package com.example.demo.business.product.infrastructure.mapper;

import com.example.demo.business.product.app.dto.response.InventoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface InventoryMapper {
    void insert(InventoryDTO inventory);
    
    void update(InventoryDTO inventory);
    
    InventoryDTO selectByProductIdAndOrgNum(@Param("productId") String productId, @Param("orgNum") String orgNum);
    
    List<InventoryDTO> selectByProductId(@Param("productId") String productId);
    
    List<InventoryDTO> selectByOrgNum(@Param("orgNum") String orgNum);
    
    List<InventoryDTO> selectAll();
}

