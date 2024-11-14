package com.example.demo.business.product.infrastructure.repository;

import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondBusinessAuth;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@Rollback(false)
class BondProductRepositoryTest {

    @Autowired
    private BondProductRepository bondProductRepository;

    @Test
    void should_save_and_update_bond_product() {
        // given - 创建测试数据
        BondProduct bondProduct = createTestBondProduct();

        // when - 保存数据
        bondProductRepository.saveProduct(bondProduct);

        // then - 验证更新
        bondProduct.setSaleArea("330000");  // 修改为浙江省
        bondProduct.setSellableCustomerType("02");  // 修改客户类型
        bondProductRepository.updateProduct(bondProduct);
    }

    private BondProduct createTestBondProduct() {
        // 创建债券信息
        Bond bond = new Bond();
        bond.setBondCode("019666");  // 示例国债代码
        
        // 创建业务权限
        BondBusinessAuth authority = new BondBusinessAuth();
        authority.enableAllTransactions();
        authority.enable(BondBusinessAuth.TransactionType.BUY_SELL);
        authority.enable(BondBusinessAuth.TransactionType.TRANSFER);
        authority.setBondCode("019666");

        // 构建产品信息，确保 FDM_PRODUCT_CODE 长度不超过64
        return BondProduct.builder()
                .withProductCode("152029001")
                .withFDMCode("FDM019666")    // 使用简短的FDM编码
                .withBond(bond)
                .withAuthority(authority)
                .withSaleArea("320000")      // 江苏省
                .withSellableCustomerType("01") // 个人客户
                .build();
    }
} 