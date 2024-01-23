package com.example.demo.business.product.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.product.domain.domainObject.Bond;
import com.example.demo.business.product.domain.domainObject.BondProduct;
import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.domain.service.BondProductService;
import com.example.demo.business.product.domain.service.BondQuotationService;
import com.example.demo.business.product.domain.service.ChannelService;
import com.example.demo.business.product.repository.InventoryRepo;
import com.example.demo.business.product.repository.dto.BondInfoDto;
import com.example.demo.business.product.repository.dto.ChangeQuoteDto;
import com.example.demo.business.product.repository.dto.QuotationDto;

@RestController
@RequestMapping("/bond/v1")
public class ProductManager {

    @Autowired
    private BondProductService productServcie;

    @Autowired
    private BondQuotationService quotationService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private InventoryRepo invRepo;

    /**
     * 债券录入
     * 使用 TESLA 框架时，该方法并非对外发布的 function 接口，而是 app service
     * 但参数仍为 adapter 转化后对应的 DTO，目标是兼容旧版协议
     * @param dto
     * @return
     */
    @PostMapping("/product/register")
    public ResponseEntity<String> setKeepAccount(@RequestBody BondInfoDto dto) {
        
        //TODO 接口-setKeepAccount，需要增加续发行录入
        if (productServcie.registBond(dto)) {
            return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bond registered failed", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 产品更新
     * @param dto 更新债券参数
     * @return
     */
    @PostMapping("/product/update")
    public ResponseEntity<String> updateKeepAccount(@RequestBody BondInfoDto dto) {
        
        //TODO 接口-updateKeepAccount
        return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
    }

    /**
     * 
     * @param productCode 产品代码
     * @param tradeType 交易类型
     * @param switchState 开关状态
     * @return
     */
    @PostMapping("/product/tradeSwitch/auth")
    public ResponseEntity<String> tradeSwitchSet(@RequestParam String productCode, @RequestParam String tradeType,
    @RequestParam String switchState) {
        
        //TODO 接口-tradeSwitchSet,将产品的某个交易权限打开或者关闭
        return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
    }

    /**
     * 
     * @param productCode
     * @param switchState
     * @return
     */
    @PostMapping("/product/switch/auth")
    public ResponseEntity<String> productSwitchSet(@RequestParam String productCode, @RequestParam String switchState) {
        
        //TODO 接口-productSwitchSet
        return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
    }

    /**
     * 重置开关状态
     * @param productCode
     * @return
     */
    @PostMapping("/product/switch/reset")
    public ResponseEntity<String> renewDefaultSet(@RequestParam String productCode) {
        
        //TODO 接口-renewDefaultSet
        return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
    }


    /**
     * 产品查询接口
     * @return
     */
    @PostMapping("/product/list")
    public List<Bond> queryKeAcBriefInfo() {
        
        //TODO 接口-queryKeAcBriefInfo 债券信息查询，支持单个/列表,返回参数需要重新封装定义，并补充一些条件入参
        return null;
    }

    /*
     * 债券列表查询，历史原因导致的冗余接口，返回基础数据，目前 GRM 调用
     */
    @PostMapping("/product/list2")
    public List<Bond> queryBondList() {
        
        //TODO 接口-queryKeAcBriefInfo 债券信息查询，支持单个/列表,返回参数需要重新封装定义，并补充一些条件入参
        return null;
    }


    /**
     * 产品详情查询
     * @param productCode
     * @return
     */
    @PostMapping("/product/detail")
    public BondProduct queryKeAcDetailedInfo(@RequestParam String productCode) {
        
        //TODO 接口-queryKeAcDetailedInfo 债券详细查询，返回参数需要重新封装定义
        return null;
    }
    
    /**
     * 查询推荐债券，该接口存在冗余
     * @return
     */
    @PostMapping("/product/recommend")
    public List<Bond> queryKeAcTuiJianInfo() {
        
        //TODO 接口-queryKeAcTuiJianInfo 推荐债券查询，直接查库即可
        return null;
    }

    /**
     * 历史原因冗余？目前由GRM 调用
     * @return
     */
    @PostMapping("/product/recommend2")
    public List<Bond> queryRecommendedKeAcBondList() {
        
        //TODO 接口-queryRecommendedKeAcBondList 推荐债券查询，直接查库即可
        return null;
    }

    /**
     * 
     * @param request 推荐债券列表
     * @return
     */
    @PostMapping("/product/setRecomment")
    public ResponseEntity<String> recommendedKeAcBondSet(@RequestBody List<String> bondList) {
        
        //TODO 接口-queryKeAcTuiJianInfo 推荐债券查询，直接查库即可
        return new ResponseEntity<>("recommend bond set successfully", HttpStatus.OK);
    }
    


    /**
     * 额度调拨
     * @param allocDtos
     * @return
     */
    @PostMapping("/product/allocQuotation")
    public ResponseEntity<String> voucherBondFacTransfer(@RequestBody List<ChangeQuoteDto> allocDtos) {
        Inventory inv = null;
        for (ChangeQuoteDto dto : allocDtos) {

            String channelId = dto.getChannelId();
            String bondCode = dto.getBondCode();
            int amount = dto.getChangeQuantity();

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

    /**
     * 报价试算
     * @param list
     * @return
     */
    public ResponseEntity<String> keepAccountsPriceCountBatch(@RequestBody List<QuotationDto> list){
                
        
        return ResponseEntity.ok("Alloc quotation received and processed");
    }


}
