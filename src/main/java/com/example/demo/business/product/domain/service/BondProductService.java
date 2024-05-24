package com.example.demo.business.product.domain.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.business.product.adapter.response.dto.InventoryDTO;
import com.example.demo.business.product.domain.domainObject.Bond;
import com.example.demo.business.product.domain.domainObject.BondBusinessAuth;
import com.example.demo.business.product.domain.domainObject.BondProduct;
import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.domain.repository.BondProductRepo;
import com.example.demo.business.product.domain.valueObject.BondLifeCycle;
import com.example.demo.common.catchall.CatchAndLog;
import com.example.demo.common.exception.BizException;
import com.example.demo.exception.BaseData;
@Component
@CatchAndLog
public class BondProductService {
    @Autowired
    private static final Logger logger = LogManager.getLogger(BondProductService.class);

    @Autowired
    private BondProductRepo repo;

    /**
     * TODO 查询债券详情
     * @param bondCode
     * @return
     */
    public Bond getBondDetailInfo(String bondCode){
        return null;
    }

    public InventoryDTO getInventory(){
        throw new BizException("95568", "test biz exception");
    }

    /**
     * TODO 债券基础信息注册， 用于自动解析下发的债券信息文件并录入基础数据
     * 注意虽然债券基础信息录入后，由于产品并未设置，因此不会有产品信息
     * @param bondinfoDto 债券注册参数
     * @return
     */
    public boolean registBond(Bond bondinfo){

        return repo.registBond(bondinfo);
    }

    /**
     * TODO 产品设置，只有产品表数据完备才能认为产品注册流程完成
     * @return
     */
    public BaseData registProduct(BondProduct product, boolean isReissue){
        
        String transId = "1000001";
        BaseData returnData = new BaseData();
        if(isReissue){
            //续发行债券产品录入
            returnData.setReturnMsg("regist reissue bond OK");
        }else{
            //新产品录入
            returnData.setReturnMsg("regist new bond");
        }
        
        return new BaseData(true, transId);
    }

    /**
     * TODO 产品查询
     * @param bondCode 债券代码，非必输
     * @param lifeCycle 债券生命周期，非必输
     */
    public List<BondProduct> getProduct(String bondCode, BondLifeCycle lifeCycle){
        return null;
    }

    /**
     * TODO 产品权限更新(数据库操作)
     * @param bondCode 债券代码，非必输
     * @param lifeCycle 债券生命周期，非必输
     */
    public void updateProductAuth(BondBusinessAuth auth){

    }

    /**
     *  TODO 产品续发行合并
     * @param bondCode
     */

    public void mergeReissue(String bondCode){

    }

}
