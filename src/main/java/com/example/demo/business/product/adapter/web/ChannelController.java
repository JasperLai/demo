package com.example.demo.business.product.adapter.web;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.product.adapter.request.AgentDto;
import com.example.demo.business.product.adapter.request.ChangeQuoteDto;
import com.example.demo.business.product.adapter.response.InventoryGetResponse;
import com.example.demo.business.product.adapter.response.dto.InventoryDTO;
import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.domain.repository.InventoryRepo;
import com.example.demo.business.product.domain.repository.TraderRepo;
import com.example.demo.business.product.domain.service.BondProductService;
import com.example.demo.common.catchall.CatchAndLog;

@RestController
@RequestMapping("/bond/channel")
public class ChannelController {

    private InventoryRepo invRepo;

    private TraderRepo traderRepo;

    @Autowired
    private BondProductService  bs;

    /**
     * 额度调拨
     * @param allocDtos
     * @return
     */
    @PostMapping("/allocQuotation")
    public ResponseEntity<String> voucherBondFacTransfer(@RequestBody List<ChangeQuoteDto> allocDtos) {
        Inventory inv = null;
        try {
            
            for (ChangeQuoteDto dto : allocDtos) {
    
                String channelId = dto.getChannelId();
                String bondCode = dto.getBondCode();
                int amount = dto.getChangeQuantity();
    
                //加载库存数据
                inv = invRepo.queryInventory(dto);
            
             
    
            }
            //遍历后更新库存
            invRepo.saveInventory(inv);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return ResponseEntity.ok("Alloc quotation received and processed");
    }


    /**
     * 新增代理商
     * @param agent
     * @return
     */
    @PostMapping("/agent/add")
    public ResponseEntity<String> addAgentInfo(@RequestBody AgentDto agent) {

        //TODO 接口-keepAccountsLimitSet 设置库存上下限
        return ResponseEntity.ok("processed");
    }

    /**
     * 删除代理商
     * @param agent
     * @return
     */
    @PostMapping("/agent/delete")
    public ResponseEntity<String> deleteAgentInfo(@RequestBody AgentDto agent) {

        //TODO 接口-keepAccountsLimitSet 设置库存上下限
        return ResponseEntity.ok("processed");
    }

    /**
     * 更新代理商信息
     * @param agent
     * @return
     */
    @PostMapping("/agent/update")
    public ResponseEntity<String> storeAgentInfo(@RequestBody AgentDto agent) {

        //TODO 接口-keepAccountsLimitSet 设置库存上下限
        return ResponseEntity.ok("processed");
    }

    /**
     * 
     * @param productCode 两个参数输入一个记忆可以
     * @param bondCode 
     * @return 债券代码，产品代码, 当前库存，最高限额，最低限额，可买入额度，可卖出额度
     */
    @GetMapping("/inventory/get")
    public InventoryGetResponse queryKeAcFacility(@RequestParam String productCode, 
    @RequestParam String bondCode) {

        InventoryDTO inv = (InventoryDTO)bs.getInventory();
        InventoryGetResponse response = new InventoryGetResponse();

        response.setErrCode(inv.getErrCode());
        response.setErrMessage(inv.getErrMsg());
        response.setSuccess(inv.getSuccess());
        return response;
    }



}
