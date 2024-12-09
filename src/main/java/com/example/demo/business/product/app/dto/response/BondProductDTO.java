package com.example.demo.business.product.app.dto.response;

import com.example.demo.business.product.domain.entity.BondBusinessAuth;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.valueObject.FDMProductCode;
import com.example.demo.business.product.domain.valueObject.ProductId;
import com.example.demo.common.exception.data.BaseData;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class BondProductDTO extends BaseData {
    // BondProduct 相关字段
    @NotNull
    private String productId; // 产品编码
    @NotNull
    private String fdmProductCode; // FDM产品编码
    @NotNull
    private BondDTO bondDTO; // 债券代码（关联Bond）
    @NotNull
    private int bondAuth; // 产品交易权限
    private String saleArea; // 销售区域
    private String sellableCustomerType; // 可售客户类别
    private String sellableCustomerRiskLevel;// 可售客户风险等级
    private String pledgeableSign; // 可质押标志
    private String reissueFlag; // 续发行标志
    private BigDecimal reissueIncomeRate; // 续发行到期收益率
    private String recommendFlag; // 推荐标志
    private String quotaMode; // 报价模式
    private String bidSpread; // 买价点差
    private String askSpread; // 卖价点差
    private Long upperLimitHolding; // 银行持有上限
    private Long lowerLimitHolding; // 银行持有下限

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productCode) {
        this.productId = productCode;
    }

    public String getFdmProductCode() {
        return fdmProductCode;
    }

    public void setFdmProductCode(String fdmProductCode) {
        this.fdmProductCode = fdmProductCode;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    public String getSellableCustomerType() {
        return sellableCustomerType;
    }

    public void setSellableCustomerType(String sellableCustomerType) {
        this.sellableCustomerType = sellableCustomerType;
    }

    public String getSellableCustomerRiskLevel() {
        return sellableCustomerRiskLevel;
    }

    public void setSellableCustomerRiskLevel(String sellableCustomerRiskLevel) {
        this.sellableCustomerRiskLevel = sellableCustomerRiskLevel;
    }

    public String getPledgeableSign() {
        return pledgeableSign;
    }

    public void setPledgeableSign(String pledgeableSign) {
        this.pledgeableSign = pledgeableSign;
    }

    public String getReissueFlag() {
        return reissueFlag;
    }

    public void setReissueFlag(String reissueFlag) {
        this.reissueFlag = reissueFlag;
    }

    public BigDecimal getReissueIncomeRate() {
        return reissueIncomeRate;
    }

    public void setReissueIncomeRate(BigDecimal reissueIncomeRate) {
        this.reissueIncomeRate = reissueIncomeRate;
    }

    public String getRecommendFlag() {
        return recommendFlag;
    }

    public void setRecommendFlag(String recommendFlag) {
        this.recommendFlag = recommendFlag;
    }

    public String getQuotaMode() {
        return quotaMode;
    }

    public void setQuotaMode(String quotaMode) {
        this.quotaMode = quotaMode;
    }

    public String getBidSpread() {
        return bidSpread;
    }

    public void setBidSpread(String bidSpread) {
        this.bidSpread = bidSpread;
    }

    public String getAskSpread() {
        return askSpread;
    }

    public void setAskSpread(String askSpread) {
        this.askSpread = askSpread;
    }

    public Long getUpperLimitHolding() {
        return upperLimitHolding;
    }

    public void setUpperLimitHolding(Long upperLimitHolding) {
        this.upperLimitHolding = upperLimitHolding;
    }

    public Long getLowerLimitHolding() {
        return lowerLimitHolding;
    }

    public void setLowerLimitHolding(Long lowerLimitHolding) {
        this.lowerLimitHolding = lowerLimitHolding;
    }

    public BondDTO getBondDTO() {
        return bondDTO;
    }

    public void setBondDTO(BondDTO bondDTO) {
        this.bondDTO = bondDTO;
    }

    public String getBondCode() {
        return bondDTO.getBondCode();
    }

    public int getBondAuth() {
        return bondAuth;
    }

    public void setBondAuth(int bondAuth) {
        this.bondAuth = bondAuth;
    }

    public static BondProductDTO fromEntity(BondProduct entity, boolean withBondDetail) {
        if (entity == null) {
            return null;
        }

        BondProductDTO dto = new BondProductDTO();
        dto.setProductId(entity.getProductId());
        dto.setFdmProductCode(entity.getFDMCode());
        if (entity.getAuthority() != null) {
            dto.setBondAuth(entity.getAuthority().getPermissions());
        }
        dto.setSaleArea(entity.getSaleArea());
        dto.setSellableCustomerType(entity.getSellableCustomerType());
        dto.setSellableCustomerRiskLevel(entity.getSellableCustomerRiskLevel());
        dto.setPledgeableSign(entity.getPledgeableSign());
        dto.setReissueFlag(entity.getReissueFlag());
        dto.setReissueIncomeRate(entity.getReissueIncomeRate());
        dto.setRecommendFlag(entity.getRecommendFlag());
        dto.setQuotaMode(entity.getQuotaMode());
        dto.setBidSpread(entity.getBidSpread());
        dto.setAskSpread(entity.getAskSpread());
        dto.setUpperLimitHolding(entity.getUpperLimitHolding());
        dto.setLowerLimitHolding(entity.getLowerLimitHolding());

        if (withBondDetail) {
            dto.setBondDTO(BondDTO.fromEntity(entity.getBond()));
        } else {
            if (entity.getBond() != null) {
                BondDTO bondDTO = new BondDTO();
                bondDTO.setBondCode(entity.getBond().getBondCode());
                dto.setBondDTO(bondDTO);
            }
        }
        return dto;
    }

    public BondProduct toEntity() {
        BondProduct product = BondProduct.builder()
                .withSaleArea(this.saleArea)
                .withSellableCustomerType(this.sellableCustomerType)
                .build();

        // 设置其他基本属性
        product.setFDMCode(FDMProductCode.of(this.fdmProductCode));
        product.setProductId(ProductId.of(this.productId));
        product.setAuthority(new BondBusinessAuth(this.bondAuth));
        product.setSellableCustomerRiskLevel(this.sellableCustomerRiskLevel);
        product.setPledgeableSign(this.pledgeableSign);
        product.setReissueFlag(this.reissueFlag);
        product.setReissueIncomeRate(this.reissueIncomeRate);
        product.setRecommendFlag(this.recommendFlag);
        product.setQuotaMode(this.quotaMode);
        product.setBidSpread(this.bidSpread);
        product.setAskSpread(this.askSpread);
        product.setUpperLimitHolding(this.upperLimitHolding);
        product.setLowerLimitHolding(this.lowerLimitHolding);

        // 设置Bond对象
        if (this.bondDTO != null) {
            product.setBond(this.bondDTO.toEntity());
        }

        return product;
    }

    public BondProduct toRegisterEntity() {
        BondProduct product = BondProduct.builder()
                .withProductCode(this.getBondCode())
                .withFDMCode(this.getBondCode())
                .withSaleArea(this.saleArea)
                .withSellableCustomerType(this.sellableCustomerType)
                .build();

        // 设置其他基本属性
        product.setSellableCustomerRiskLevel(this.sellableCustomerRiskLevel);
        product.setPledgeableSign(this.pledgeableSign);
        product.setReissueFlag(this.reissueFlag);
        product.setReissueIncomeRate(this.reissueIncomeRate);
        product.setRecommendFlag(this.recommendFlag);
        product.setQuotaMode(this.quotaMode);
        product.setBidSpread(this.bidSpread);
        product.setAskSpread(this.askSpread);
        product.setUpperLimitHolding(this.upperLimitHolding);
        product.setLowerLimitHolding(this.lowerLimitHolding);

        return product;
    }
}
