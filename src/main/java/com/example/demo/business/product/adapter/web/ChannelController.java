package com.example.demo.business.product.adapter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.product.adapter.request.QueryKeAcPriceRequest;
import com.example.demo.business.product.adapter.response.QueryKeAcFacilityResponse;
import com.example.demo.business.product.adapter.response.QueryKeAcPriceResponse;
import com.example.demo.business.product.domain.repository.dto.AgentDTO;
import com.example.demo.business.product.domain.repository.dto.InventoryDTO;
import com.example.demo.business.product.domain.service.BondProductService;
import com.example.demo.common.exception.data.ListData;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/bond/channel")
public class ChannelController {


    @Autowired
    private BondProductService  service;

    /**
     * 额度调拨
     * @param allocDtos
     * @return
     */
    // @PostMapping("/allocQuotation")
    // public ResponseEntity<String> voucherBondFacTransfer(@RequestBody List<ChangeQuoteDto> allocDtos) {
      
    //     return ResponseEntity.ok("Alloc quotation received and processed");
    // }


    /**
     * 新增代理商
     * @param agent
     * @return
     */
    @PostMapping("/agent/add")
    public ResponseEntity<String> addAgentInfo(@RequestBody AgentDTO agent) {

        //TODO 接口-keepAccountsLimitSet 设置库存上下限
        return ResponseEntity.ok("processed");
    }

    /**
     * 删除代理商
     * @param agent
     * @return
     */
    @PostMapping("/agent/delete")
    public ResponseEntity<String> deleteAgentInfo(@RequestBody AgentDTO agent) {

        //TODO 接口-keepAccountsLimitSet 设置库存上下限
        return ResponseEntity.ok("processed");
    }

    /**
     * 更新代理商信息
     * @param agent
     * @return
     */
    @PostMapping("/agent/update")
    public ResponseEntity<String> storeAgentInfo(@RequestBody AgentDTO agent) {

        //TODO 接口-keepAccountsLimitSet 设置库存上下限
        return ResponseEntity.ok("processed");
    }

    /**
     * 
     * @param productCode 两个参数输入一个记忆可以
     * @param bondCode 
     * @return 债券代码，产品代码, 当前库存，最高限额，最低限额，可买入额度，可卖出额度
     */

    @PostMapping("/inventory/query")
    public ResponseEntity<QueryKeAcFacilityResponse> queryKeAcFacility(@RequestBody QueryKeAcPriceRequest request) {

        // InventoryDTO inv = service.getInventory(request.getBond_Code(),request.getProduct_Code());
        InventoryDTO inv = null;
        QueryKeAcFacilityResponse v = new QueryKeAcFacilityResponse(inv);
        v.setBond_code(inv.getBondCd());
        v.setProduce_code(request.getProduct_Code());
        v.setFacility_useable(String.valueOf(inv.getBondLimit()));
        return new ResponseEntity<>(v, HttpStatus.OK);
    }

    @PostMapping("/inventory/queryAll")
    public ResponseEntity<QueryKeAcPriceResponse> queryKeAcFacilitylist(@RequestBody QueryKeAcPriceRequest request) {

        // ListData<InventoryDTO> invlist = (ListData<InventoryDTO>)service.getInventoryList(
        //     Integer.valueOf(request.getView_index()),
        //     Integer.valueOf(request.getView_size()));

        ListData<InventoryDTO> invlist = null;
        QueryKeAcPriceResponse v = new QueryKeAcPriceResponse(invlist);
        
        return new ResponseEntity<>(v, HttpStatus.OK);

    
    }



}
