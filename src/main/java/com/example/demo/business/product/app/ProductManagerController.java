package com.example.demo.business.product.app;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.product.app.request.ProductRequest;
import com.example.demo.business.product.domain.domainObject.Bond;
import com.example.demo.business.product.domain.domainObject.BondBusinessAuth;
import com.example.demo.business.product.domain.domainObject.BondProduct;
import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.domain.repository.BondProductRepo;
import com.example.demo.business.product.domain.repository.InventoryRepo;
import com.example.demo.business.product.domain.repository.dto.QuotationDto;
import com.example.demo.business.product.domain.service.BondProductService;
import com.example.demo.business.product.domain.valueObject.BondVariety;
import com.example.demo.business.product.domain.valueObject.Currency;
import com.example.demo.business.product.domain.valueObject.InterestBase;
import com.example.demo.business.product.domain.valueObject.InterestType;

@RestController
@RequestMapping("/bond/product")
public class ProductManagerController {

    @Autowired
    private BondProductService productServcie;

    @Autowired
    private InventoryRepo invRepo;

    @Autowired
    private BondProductRepo productRepo;

    /**
     * !!!债券录入，本方法合并了 adapter 和 app 层
     * 
     * @param dto
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<String> setKeepAccount(@RequestBody ProductRequest dto) {

        try {
            // adapter层任务，构建领域对象
            BondProduct product = BondProduct.builder()
            .withProductCode(dto.getBond_code())
            .withFDMCode(dto.getBond_code())
            .withBond(parseBond(dto))
            .withAuthority(new BondBusinessAuth(0))
            .withInventory(new Inventory.InventoryBuilder()
            .initializeInventory(dto.getBond_code(), Integer.valueOf(dto.getConsign_quantum()))
            .build())
            .build();

            //app 服务，产品注册
            if (productServcie.registProduct(product,Boolean.getBoolean(dto.getXfx_flag()))) {
                return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Bond registered failed", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {

            return new ResponseEntity<>("Bond registered exception", HttpStatus.BAD_REQUEST);
        }

    }


    private Bond parseBond(ProductRequest request) throws Exception {
        Bond b = new Bond();

        b.setBondCode(request.getBond_code());
        b.setFullName(request.getBond_name());
        b.setShortName(request.getBond_short_name());
        b.setCoupon(new BigDecimal(request.getCurrent_par_interestrate()));
        b.setVariety(BondVariety.valueOf(request.getBond_variety())); // TODO 这个字段需要字典转换映射
        b.setBondTerm(Integer.valueOf(request.getBond_time()));
        b.setCurrency(request.getCurrency_code());
        b.setIssuer("");// TODO 旧协议未传输 需补充
        b.setIssuePrice(new BigDecimal(request.getIssue_price()));
        b.setTransferPauseDayBeforeCash(Integer.valueOf(request.getBefpay_altertrust_stopdays()));
        b.setMatureDate(new SimpleDateFormat("yyyyMMdd").parse(request.getCash_date()));
        b.setIssueEndDate(new SimpleDateFormat("yyyyMMdd").parse(request.getEnd_sepsell_date()));
        b.setIssueStartDate(new SimpleDateFormat("yyyyMMdd").parse(request.getInitial_sepsell_date()));
        b.setStartTradeDate(new SimpleDateFormat("yyyyMMdd").parse(request.getMaket_circulating_date()));
        b.setStartIntDate(new SimpleDateFormat("yyyyMMdd").parse(request.getBegin_calinterest_date()));
        b.setParValue(Integer.valueOf(request.getIssue_date()));
        b.setInterestBase(InterestBase.valueOf(request.getCalinterest_norm())); // TODO 需要字典转换
        b.setInterestType(InterestType.valueOf(request.getCalinterest_mode())); // 需要字典转换，并且根据付息频率进一步更新该字段
        return b;
    }

    /**
     * 产品更新
     * 
     * @param dto 更新债券参数
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<String> updateKeepAccount(@RequestBody ProductRequest dto) {

        // TODO 接口-updateKeepAccount
        return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
    }

    /**
     * 
     * @param bondCode   债券代码
     * @param upperLimit 银行持有上限
     * @param lowerLimit 银行持有下限
     * @return
     */
    @PostMapping("/limitSet")
    public ResponseEntity<String> keepAccountsLimitSet(@RequestParam String bondCode,
            @RequestParam long upperLimit, @RequestParam long lowerLimit) {

        productRepo.updateLimit(upperLimit, lowerLimit);
        return ResponseEntity.ok("processed");

    }

    /**
     * 
     * @param productCode 产品代码
     * @param tradeType   交易类型
     * @param switchState 开关状态
     * @return
     */
    @PostMapping("/tradeSwitch/auth")
    public ResponseEntity<String> tradeSwitchSet(@RequestParam String productCode, @RequestParam String tradeType,
            @RequestParam String switchState) {

        // TODO 接口-tradeSwitchSet,将产品的某个交易权限打开或者关闭
        return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
    }

    /**
     * 
     * @param productCode
     * @param switchState
     * @return
     */
    @PostMapping("/switch/auth")
    public ResponseEntity<String> productSwitchSet(@RequestParam String productCode, @RequestParam String switchState) {

        // TODO 接口-productSwitchSet
        return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
    }

    /**
     * 重置开关状态
     * 
     * @param productCode
     * @return
     */
    @PostMapping("/switch/reset")
    public ResponseEntity<String> renewDefaultSet(@RequestParam String productCode) {

        // TODO 接口-renewDefaultSet
        return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
    }

    /**
     * 产品查询接口
     * 
     * @return
     */
    @PostMapping("/list")
    public List<Bond> queryKeAcBriefInfo() {

        // TODO 接口-queryKeAcBriefInfo 债券信息查询，支持单个/列表,返回参数需要重新封装定义，并补充一些条件入参
        return null;
    }

    /*
     * 债券列表查询，历史原因导致的冗余接口，返回基础数据，目前 GRM 调用
     */
    @PostMapping("/list2")
    public List<Bond> queryBondList() {

        // TODO 接口-queryKeAcBriefInfo 债券信息查询，支持单个/列表,返回参数需要重新封装定义，并补充一些条件入参
        return null;
    }

    /**
     * 产品详情查询
     * 
     * @param productCode
     * @return
     */
    @PostMapping("/detail")
    public BondProduct queryKeAcDetailedInfo(@RequestParam String productCode) {

        // TODO 接口-queryKeAcDetailedInfo 债券详细查询，返回参数需要重新封装定义
        return null;
    }

    /**
     * 查询推荐债券，该接口存在冗余
     * 
     * @return
     */
    @PostMapping("/recommend")
    public List<Bond> queryKeAcTuiJianInfo() {

        // TODO 接口-queryKeAcTuiJianInfo 推荐债券查询，直接查库即可
        return null;
    }

    /**
     * 历史原因冗余？目前由GRM 调用
     * 
     * @return
     */
    @PostMapping("/recommend2")
    public List<Bond> queryRecommendedKeAcBondList() {

        // TODO 接口-queryRecommendedKeAcBondList 推荐债券查询，直接查库即可
        return null;
    }

    /**
     * 
     * @param request 推荐债券列表
     * @return
     */
    @PostMapping("/setRecomment")
    public ResponseEntity<String> recommendedKeAcBondSet(@RequestBody List<String> bondList) {

        // TODO 接口-queryKeAcTuiJianInfo 推荐债券查询，直接查库即可
        return new ResponseEntity<>("recommend bond set successfully", HttpStatus.OK);
    }

    /**
     * 报价试算
     * 
     * @param list
     * @return
     */
    public ResponseEntity<String> keepAccountsPriceCountBatch(@RequestBody List<QuotationDto> list) {

        return ResponseEntity.ok("Alloc quotation received and processed");
    }

}
