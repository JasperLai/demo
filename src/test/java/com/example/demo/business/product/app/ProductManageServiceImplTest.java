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
        productDTO.setProductCode("PROD001");
        productDTO.setFdmProductCode("FDM001");
        productDTO.setBondAuth(1);
        
        // 设置BondDTO
        BondDTO bondDTO = new BondDTO();
        bondDTO.setBondCode(bondCode);
        productDTO.setBondDTO(bondDTO);
        
        // 可选字段
        productDTO.setSaleArea("TEST_AREA");
        
        Bond mockBond = new Bond();
        mockBond.setBondCode(bondCode);
        
        // 模拟依赖行为
        when(bondProductRepository.findBondByBondCode(bondCode)).thenReturn(mockBond);
        when(bondProductRepository.findByProductId(productDTO.getProductCode())).thenReturn(null);
        
        // 执行测试
        BaseData result = productManageService.registBondProduct(bondCode, productDTO);
        
        // 验证结果
        assertTrue(result.isSuccess());
        assertEquals("产品录入成功", result.getReturnMsg());
        
        // 验证方法调用
        verify(bondProductRepository).findBondByBondCode(bondCode);
        verify(bondProductRepository).findByProductId(productDTO.getProductCode());
        verify(bondProductRepository).saveProduct(any(BondProduct.class));
    }

    @Test
    void registBondProduct_BondNotFound() {
        // 准备测试数据
        String bondCode = "INVALID_BOND";
        BondProductDTO productDTO = new BondProductDTO();
        
        // 模拟依赖行为
        when(bondProductRepository.findBondByBondCode(bondCode)).thenReturn(null);
        
        // 执行测试
        BaseData result = productManageService.registBondProduct(bondCode, productDTO);
        
        // 验证结果
        assertFalse(result.isSuccess());
        assertEquals("债券代码不存在", result.getReturnMsg());
        
        // 验证方法调用
        verify(bondProductRepository).findBondByBondCode(bondCode);
        verify(bondProductRepository, never()).saveProduct(any(BondProduct.class));
    }

    @Test
    void registBondProduct_DuplicateProduct() {
        // 准备测试数据
        String bondCode = "BOND001";
        BondProductDTO productDTO = new BondProductDTO();
        productDTO.setProductCode("EXISTING_PROD");
        productDTO.setFdmProductCode("FDM001");
        productDTO.setBondAuth(1);
        
        // 设置BondDTO
        BondDTO bondDTO = new BondDTO();
        bondDTO.setBondCode(bondCode);
        productDTO.setBondDTO(bondDTO);
        
        Bond mockBond = new Bond();
        BondProduct existingProduct = BondProduct.builder()
            .withProductCode("EXISTING_PROD")
            .withSaleArea("TEST_AREA")
            .build();
        
        // 模拟依赖行为
        when(bondProductRepository.findBondByBondCode(bondCode)).thenReturn(mockBond);
        when(bondProductRepository.findByProductId(productDTO.getProductCode())).thenReturn(existingProduct);
        
        // 执行测试
        BaseData result = productManageService.registBondProduct(bondCode, productDTO);
        
        // 验证结果
        assertFalse(result.isSuccess());
        assertEquals("产品编码已存在", result.getReturnMsg());
        
        // 验证方法调用
        verify(bondProductRepository).findBondByBondCode(bondCode);
        verify(bondProductRepository).findByProductId(productDTO.getProductCode());
        verify(bondProductRepository, never()).saveProduct(any(BondProduct.class));
    }

    @Test
    void registBondProduct_Exception() {
        // 准备测试数据
        String bondCode = "BOND001";
        BondProductDTO productDTO = new BondProductDTO();
        productDTO.setProductCode("PROD001");
        productDTO.setFdmProductCode("FDM001");
        productDTO.setBondAuth(1);
        
        // 设置BondDTO
        BondDTO bondDTO = new BondDTO();
        bondDTO.setBondCode(bondCode);
        productDTO.setBondDTO(bondDTO);
        
        Bond mockBond = new Bond();
        
        // 模拟依赖行为
        when(bondProductRepository.findBondByBondCode(bondCode)).thenReturn(mockBond);
        when(bondProductRepository.findByProductId(productDTO.getProductCode())).thenReturn(null);
        doThrow(new RuntimeException("数据库错误")).when(bondProductRepository).saveProduct(any(BondProduct.class));
        
        // 执行测试
        BaseData result = productManageService.registBondProduct(bondCode, productDTO);
        
        // 验证结果
        assertFalse(result.isSuccess());
        assertEquals("产品录入失败：数据库错误", result.getReturnMsg());
        
        // 验证方法调用
        verify(bondProductRepository).findBondByBondCode(bondCode);
        verify(bondProductRepository).findByProductId(productDTO.getProductCode());
        verify(bondProductRepository).saveProduct(any(BondProduct.class));
    }
} 