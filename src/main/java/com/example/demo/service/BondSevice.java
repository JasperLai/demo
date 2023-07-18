package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BondRegistMapper;
import com.example.demo.vo.BondRegistInfo;
import com.example.demo.vo.ManualQuotaPara;
import com.example.demo.vo.QuotaAllocation;

@Service
public class BondSevice {

    @Autowired
    private BondRegistMapper mapper;

    /**
     * @param bondRegistInfo 中债下发的债券注册信息
     */
    public boolean registBond(BondRegistInfo bondRegistInfo) {

        //数据库包括注册信息中所有的元素，并增加 流程状态wf_status(Approving,normal,returned) 和 handle_status(未处理/已处理)
        mapper.insertBondRegist(bondRegistInfo);

        
        return true;
    }

    /**
     * @param wfStatus 工作流状态更新 
     * @return
     */
    public Boolean updateBondResistStatus(int  wfStatu ) {

        return true;
    }

    
    /**
     * @param bondType 17-电子式 18-凭证式
     * 查询待录入债券列表数据
     */
    public List<BondRegistInfo> queryRegistBondList(String  bondType){

        return null;
    }

    //查询对应债券的基本额度(因基本额度不在zqzc信息中，在债券edtp额度调配文件中)
    public String queryBasicQuota(String  bondId){

        return null;
    }

    
    /**
     * @param bond  中债下发的债券注册信息
     * @param qaList 渠道额度分配列表
     * @param mqPara  机动额度抓取参数
     */
    public void enterBond(BondRegistInfo bond, List<QuotaAllocation> qaList, ManualQuotaPara mqPara){

    }
    
}
