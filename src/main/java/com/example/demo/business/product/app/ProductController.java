package com.example.demo.business.product.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.product.domain.domainObject.BondQuotation;
import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.domain.service.BondProductService;
import com.example.demo.business.product.domain.service.BondQuotationService;
import com.example.demo.business.product.domain.service.ChannelService;
import com.example.demo.business.product.repository.InventoryRepo;
import com.example.demo.business.product.repository.dto.BondInfoDto;
import com.example.demo.business.product.repository.dto.ChangeQuotationDto;

@RestController
@RequestMapping("/bond/v1")
public class ProductController {

    @Autowired
    private BondProductService productServcie;

    @Autowired
    private BondQuotationService quotationService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private InventoryRepo invRepo;

    /**
     * 使用 TESLA 框架时，该方法并非对外发布的 function 接口，而是 app service
     * 但参数仍为 adapter 转化后对应的 DTO，目标是兼容旧版协议
     * 
     * @param dto
     * @return
     */
    @PostMapping("/product/register")
    public ResponseEntity<String> setKeepAccounts(@RequestBody BondInfoDto dto) {
        if (productServcie.registBond(dto)) {
            return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bond registered failed", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 额度调拨
     * @param allocDtos
     * @return
     */
    @PostMapping("/product/allocQuotation")
    public ResponseEntity<String> voucherBondFacTransfer(@RequestBody List<ChangeQuotationDto> allocDtos) {
        Inventory inv = null;
        for (ChangeQuotationDto dto : allocDtos) {

            String channelId = dto.getChannelId();
            String bondCode = dto.getBondCode();
            int amount = dto.getAmount();

            //加载库存数据
            inv = invRepo.queryInventory(dto);
        
            if (inv.isNewBondInChannel(bondCode, channelId)) {
                //新渠道券
                inv.initializeInventory(dto);
            } else {
                //旧渠道券
                if (amount >= 0) {
                    inv.increaseInventory(dto);
                } else {
                    inv.decreaseInventory(dto);
                }
            }

        }
        //遍历后更新库存
        invRepo.saveInventory(inv);

        return ResponseEntity.ok("Alloc quotation received and processed");
    }


}
