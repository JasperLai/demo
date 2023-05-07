package com.example.bondfront.demo.domain.ebond.model.domainObject.realtime;

import java.util.Date;

import com.example.bondfront.demo.domain.ebond.model.valueObject.BondCode;
import com.example.bondfront.demo.domain.ebond.model.valueObject.ISODate;
import com.example.bondfront.demo.domain.ebond.model.valueObject.ISOTime;
import com.example.bondfront.demo.domain.ebond.model.valueObject.Quota;
import com.example.bondfront.demo.domain.ebond.model.valueObject.TransactionCode;
import com.example.bondfront.demo.domain.ebond.model.valueObject.TransactionNumber;

public class QuotaApplyMessage extends Message {


    private ISODate bizDate; //业务日期
    private ISOTime sysTime; //系统时间
    private TransactionCode tranCode; //交易标志
    private TransactionNumber seqNo; //交易序号
    private BondCode  BondCode;  //债券代码
    private Quota  leftBaseQuota; //剩余基本额度
    private Quota  leftQuota; //剩余机动额度
    private Quota  applyQuota;//申请机动额度



    public QuotaApplyMessage() {
        super("otcs.qq.q.qq");
        //TODO 初始化并校验参数信息
        createBody();
    }



    @Override
    void createBody() {
        // TODO 
        
    }
    
}
