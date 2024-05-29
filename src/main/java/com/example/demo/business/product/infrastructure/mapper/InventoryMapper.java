package com.example.demo.business.product.infrastructure.mapper;

import org.apache.ibatis.annotations.*;

import com.example.demo.business.product.domain.repository.dto.InventoryDTO;

import java.util.List;

@Mapper
public interface InventoryMapper {

    @Select("SELECT * FROM inventory WHERE BOND_CD = #{id}")
    @Results({
        @Result(property = "intOrgNum", column = "int_org_num"),
        @Result(property = "bondCd", column = "bond_cd"),
        @Result(property = "bondLimit", column = "bond_limit"),
        @Result(property = "saleStragety", column = "sale_stragety"),
        @Result(property = "trustProNum", column = "trust_pro_num")
    })
    InventoryDTO findByBondCode(String id);


    @Select("SELECT int_org_num AS intOrgNum, bond_cd AS bondCd, bond_limit AS bondLimit, " +
    "sale_stragety AS saleStragety, trust_pro_num AS trustProNum FROM inventory")
    List<InventoryDTO> findInventoryList();

    @Select("SELECT * FROM inventory WHERE int_org_num = #{id}")
    InventoryDTO findByOrgId(String id);

    @Select("SELECT * FROM inventory")
    List<InventoryDTO> findAll();

    @Insert("INSERT INTO inventory (int_org_num, bond_cd, bond_limit, sale_stragety, trust_pro_num) " +
            "VALUES (#{intOrgNum}, #{bondCd}, #{bondLimit}, #{saleStragety}, #{trustProNum})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(InventoryDTO inventory);

    @Update("UPDATE inventory SET int_org_num = #{intOrgNum}, bond_cd = #{bondCd}, bond_limit = #{bondLimit}, " +
            "sale_stragety = #{saleStragety}, trust_pro_num = #{trustProNum} WHERE id = #{id}")
    void update(@Param("id") Long id, @Param("inventory") InventoryDTO inventory);

    @Delete("DELETE FROM inventory WHERE id = #{id}")
    void delete(Long id);
}

