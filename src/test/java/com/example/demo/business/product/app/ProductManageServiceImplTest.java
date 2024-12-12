package com.example.demo.business.product.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.business.product.app.dto.response.BondDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import com.example.demo.common.exception.data.BaseData;

class ProductManageServiceImplTest {

    @InjectMocks
    private ProductManageServiceImpl productManageService;

    @Mock
    private BondProductRepository bondProductRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registBondProduct_Success() {
        // 准备测试数据
        String bondCode = "BOND001";
        BondProductDTO productDTO = new BondProductDTO();
        // productDTO.setProductCode("PROD001");
        // productDTO.setFdmProductCode("FDM001");
        // productDTO.setBondAuth(1);  // 设置交易权限
        
        // 设置 BondDTO
        BondDTO bondDTO = new BondDTO();
        bondDTO.setBondCode(bondCode);
        productDTO.setBondDTO(bondDTO);
        
        Bond mockBond = new Bond();
        mockBond.setBondCode(bondCode);
        
        // 模拟 bondProductRepository 行为
        when(bondProductRepository.findBondByBondCode(bondCode)).thenReturn(mockBond);
        
        // 执行测试方法
        productManageService.registBondProduct(productDTO);
        
        // 验证调用
        verify(bondProductRepository).findBondByBondCode(bondCode);
        verify(bondProductRepository).saveProduct(any(BondProduct.class));
    }

    @Test
    void registBondProduct_BondNotFound() {
        // 准备测试数据
        String bondCode = "INVALID_BOND";
        BondProductDTO productDTO = new BondProductDTO();
        
        // 模拟债券不存在的情况
        when(bondProductRepository.findBondByBondCode(bondCode)).thenReturn(null);
        
        // 验证抛出异常
        assertThrows(RuntimeException.class, () -> {
            productManageService.registBondProduct(productDTO);
        });
        
        // 验证调用
        verify(bondProductRepository).findBondByBondCode(bondCode);
        verify(bondProductRepository, never()).saveProduct(any(BondProduct.class));
    }

} 