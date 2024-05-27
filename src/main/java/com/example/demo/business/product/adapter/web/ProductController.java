package com.example.demo.business.product.adapter.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.product.adapter.request.SetKeepAccountRequest;
import com.example.demo.business.product.domain.domainObject.Bond;
import com.example.demo.business.product.domain.domainObject.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepo;
import com.example.demo.business.product.domain.service.BondProductService;
import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.response.ManageBaseResponse;

@RestController
@RequestMapping("/bond/product")
public class ProductController {

    @Autowired
    private BondProductService productServcie;

    @Autowired
    private BondProductRepo productRepo;

    /**
     * !!!债券录入，本方法合并了 adapter 和 app 层
     * 
     * @param dto
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<ManageBaseResponse> setKeepAccount(@RequestBody SetKeepAccountRequest request) {
        // adapter层任务，构建领域对象
        
        BaseData data = productServcie.registProduct(request.getBondVO(), Boolean.getBoolean(request.getXfx_flag()));
        return new ResponseEntity<>(new ManageBaseResponse(data), HttpStatus.OK);

    }

    /**
     * 产品更新
     * 
     * @param dto 更新债券参数
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<String> updateKeepAccount(@RequestBody SetKeepAccountRequest dto) {

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

}
