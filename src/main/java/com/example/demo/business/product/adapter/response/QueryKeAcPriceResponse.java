package com.example.demo.business.product.adapter.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.business.product.domain.repository.dto.InventoryDTO;
import com.example.demo.common.exception.data.ListData;
import com.example.demo.common.response.QueryBaseResponse;

public class QueryKeAcPriceResponse extends QueryBaseResponse {

    // 批量查询示例
    private List<protocoInventorylDTO> result;

    public QueryKeAcPriceResponse(ListData<InventoryDTO> inv) {
        super(inv);
        convert(inv);
    }
    public List<protocoInventorylDTO> getResult() {
        return result;
    }

    public void setResult(List<protocoInventorylDTO> result) {
        this.result = result;
    }

    private void convert(ListData<InventoryDTO> inv){

        List<InventoryDTO> inventoryList = inv.getList().getList();
        if(inventoryList == null){
            return;
        }
        List<protocoInventorylDTO> protocoList = new ArrayList<>();

        for (InventoryDTO inventory : inventoryList) {
            protocoInventorylDTO proto = new protocoInventorylDTO();
            proto.setInt_Org_Num(inventory.getIntOrgNum());
            proto.setBond_Cd(inventory.getBondCd());
            proto.setBond_Limit(inventory.getBondLimit());
            proto.setSale_Stragety(inventory.getSaleStragety());
            proto.setTrust_ProNum(inventory.getTrustProNum());
            protocoList.add(proto);
        }

        this.result = protocoList;
    }

    private class protocoInventorylDTO {
        
        private String int_Org_Num;
        private String bond_Cd;
        private Long bond_Limit;
        private String sale_Stragety;
        private String trust_ProNum;

        public String getInt_Org_Num() {
            return int_Org_Num;
        }
        public void setInt_Org_Num(String int_Org_Num) {
            this.int_Org_Num = int_Org_Num;
        }
        public String getBond_Cd() {
            return bond_Cd;
        }
        public void setBond_Cd(String bond_Cd) {
            this.bond_Cd = bond_Cd;
        }
        public Long getBond_Limit() {
            return bond_Limit;
        }
        public void setBond_Limit(Long bond_Limit) {
            this.bond_Limit = bond_Limit;
        }
        public String getSale_Stragety() {
            return sale_Stragety;
        }
        public void setSale_Stragety(String sale_Stragety) {
            this.sale_Stragety = sale_Stragety;
        }
        public String getTrust_ProNum() {
            return trust_ProNum;
        }
        public void setTrust_ProNum(String trust_ProNum) {
            this.trust_ProNum = trust_ProNum;
        }
    }

}
