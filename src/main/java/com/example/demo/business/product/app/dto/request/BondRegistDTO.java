package com.example.demo.business.product.app.dto.request;

import org.springframework.lang.NonNull;

public class BondRegistDTO {

    // 业务日期 格式：YYYY-MM-DD
    @NonNull
    private String businessDate;

    // 债券代码
    @NonNull
    private String bondCode;

    // 债券简称
    @NonNull
    private String bondShortName;

    //债券性质
    @NonNull
    private String bondNature;

    // 记账币种 只支持 CNY
    @NonNull
    private String denominatedCurrency;

    // 债券期限 
    @NonNull
    private String bondTerm;

    // 债券期限单位 1-年 2-月 3-日
    @NonNull
    private String bondTermUnit;

    // 债券发行价格
    @NonNull
    private String bondIssuePrice;

    // 计息方式 10-贴现 20-利随本清 31-附息式固定利率 32-附息式浮动利率 40-零息 99-无
    @NonNull
    private String interestCalculationMethod;

    // 付息周期
    private String interestPaymentCycle;

    // 票面利率
    private String couponRate;

    // 发行开始日
    @NonNull
    private String issueStartDate;

    // 起息日
    @NonNull
    private String interestStartDate;

    // 分销开始日
    @NonNull
    private String distributionStartDate;

    // 分销结束日
    @NonNull
    private String distributionEndDate;

    // 上市流通日
    private String listingDate;

    // 本计息期付息日
    private String interestPaymentDate;

    // 到期日
    @NonNull
    private String maturityDate;

    // 债券状态 00-正常 01-到期兑付
    @NonNull
    private String bondStatus;

    // 追加次数
    @NonNull
    private String addTimes;

    // 债券暂停状态 1-正常 2-暂停
    @NonNull
    private String bondPauseStatus;

    // 债权登记日
    private String bondRegistrationDate;

    // 当前本金值 
    @NonNull
    private String currentPrincipalValue;

    // 本金值生效日 
    private String principalValueEffectiveDate;

    // 第一次付息日
    private String firstInterestPaymentDate;

    // 截止过户日
    @NonNull
    private String cutoffTransferDate;
}
