package com.example.demo.business.product.infrastructure.mapper;

import com.example.demo.business.product.app.dto.request.ProductQueryVO;
import com.example.demo.business.product.app.dto.response.BondDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BondProductMapper {
    void insert(BondProductDTO dto);

    void update(BondProductDTO dto);

    BondProductDTO selectById(String id);

    BondProductDTO selectByBondCode(String bondCode);

    List<BondProductDTO> selectAll();

    List<BondProductDTO> selectByCondition(ProductQueryVO vo);

    void insertBond(BondDTO dto);

    void updateBond(BondDTO dto);

    BondDTO selectBondByBondCode(String bondCode);

    List<BondDTO> selectAllBonds();
}