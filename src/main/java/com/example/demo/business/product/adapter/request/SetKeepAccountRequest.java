package com.example.demo.business.product.adapter.request;

import com.example.demo.business.product.domain.repository.dto.BondDTO;
import com.example.demo.common.request.ManageBaseRequest;

public class SetKeepAccountRequest extends ManageBaseRequest{
    private String productId;

    private String product_code;

    private String bond_code;

    private String xfx_flag;

    private String xfx_rateOfIncome;

    private String original_bond_code; 

    private String bond_variety;

    private String bond_name;

    private String bond_short_name;

    private String local_bond_sales_area; 

    private String currency_code; 

    private String bond_issue_year;  

    private String bond_issue_term;

    private String bond_time;

    private String current_par_interest_rate;

    private String float_par_interrate_norm;

    private String float_par_interbalance;

    private String cal_interest_mode;

    private String cal_interest_norm;

    private String pay_interest_frequency;

    private String bond_issue_uplimit;
    
    private String bond_issue_lowlimit;

    private String bond_change_unit;

    private String issue_date;

    private String begin_cal_interest_date;

    private String initial_sep_sell_date;

    private String end_sep_sell_date;

    private String market_circulating_date;

    private String cash_date;

    private String befpay_altertrust_stopdays;

    private String befpay_bond_registerdays;

    private String close_transfer_days;

    private String consign_quantum;

    private String issue_price;

    private String befCashDay_OutRequest_stopdays;

    private String trustship_site;


    public BondDTO getBondVO() {
        BondDTO bondVO = new BondDTO();
        bondVO.setBondCode(this.bond_code);
        bondVO.setBondName(this.bond_name);
        bondVO.setBondShortName(this.bond_short_name);
        bondVO.setBondVariety(this.bond_variety);
        bondVO.setBondTerm(this.bond_issue_term);
        bondVO.setCoupon(this.current_par_interest_rate);
        bondVO.setCurrencyCode(this.currency_code);
        bondVO.setIssuer(null); // 原接口未传发行人
        bondVO.setIssuePrice(this.issue_price);
        bondVO.setTransferPauseDayBeforeCash(this.close_transfer_days); // 截止过户日
        bondVO.setMatureDate(this.cash_date);
        bondVO.setIssueDeadline(this.end_sep_sell_date);
        bondVO.setListingDate(this.market_circulating_date);
        bondVO.setAccrualDate(this.begin_cal_interest_date);
        bondVO.setIssueDate(this.initial_sep_sell_date);
        bondVO.setAccrualBase(this.cal_interest_norm);
        bondVO.setAccrualMethod(this.cal_interest_mode);
        bondVO.setAccrualPeriod(this.pay_interest_frequency);
        bondVO.setParValue("100"); // 原接口未传面值
        bondVO.setCustodyOrg(this.trustship_site);
        return bondVO;
    }

    
    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProduct_code() {
        return this.product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getBond_code() {
        return this.bond_code;
    }

    public void setBond_code(String bond_code) {
        this.bond_code = bond_code;
    }

    public String getXfx_flag() {
        return this.xfx_flag;
    }

    public void setXfx_flag(String xfx_flag) {
        this.xfx_flag = xfx_flag;
    }

    public String getXfx_rateOfIncome() {
        return this.xfx_rateOfIncome;
    }

    public void setXfx_rateOfIncome(String xfx_rateOfIncome) {
        this.xfx_rateOfIncome = xfx_rateOfIncome;
    }

    public String getOriginal_bond_code() {
        return this.original_bond_code;
    }

    public void setOriginal_bond_code(String original_bond_code) {
        this.original_bond_code = original_bond_code;
    }

    public String getBond_variety() {
        return this.bond_variety;
    }

    public void setBond_variety(String bond_variety) {
        this.bond_variety = bond_variety;
    }

    public String getBond_name() {
        return this.bond_name;
    }

    public void setBond_name(String bond_name) {
        this.bond_name = bond_name;
    }

    public String getBond_short_name() {
        return this.bond_short_name;
    }

    public void setBond_short_name(String bond_short_name) {
        this.bond_short_name = bond_short_name;
    }

    public String getLocal_bond_sales_area() {
        return this.local_bond_sales_area;
    }

    public void setLocal_bond_sales_area(String local_bond_sales_area) {
        this.local_bond_sales_area = local_bond_sales_area;
    }

    public String getCurrency_code() {
        return this.currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getBond_issue_year() {
        return this.bond_issue_year;
    }

    public void setBond_issue_year(String bond_issue_year) {
        this.bond_issue_year = bond_issue_year;
    }

    public String getBond_issue_term() {
        return this.bond_issue_term;
    }

    public void setBond_issue_term(String bond_issue_term) {
        this.bond_issue_term = bond_issue_term;
    }

    public String getBond_time() {
        return this.bond_time;
    }

    public void setBond_time(String bond_time) {
        this.bond_time = bond_time;
    }

    public String getCurrent_par_interestrate() {
        return this.current_par_interest_rate;
    }

    public void setCurrent_par_interestrate(String current_par_interestrate) {
        this.current_par_interest_rate = current_par_interestrate;
    }

    public String getFloat_par_interrate_norm() {
        return this.float_par_interrate_norm;
    }

    public void setFloat_par_interrate_norm(String float_par_interrate_norm) {
        this.float_par_interrate_norm = float_par_interrate_norm;
    }

    public String getFloat_par_interbalance() {
        return this.float_par_interbalance;
    }

    public void setFloat_par_interbalance(String float_par_interbalance) {
        this.float_par_interbalance = float_par_interbalance;
    }

    public String getCal_interest_mode() {
        return this.cal_interest_mode;
    }

    public void setCal_interest_mode(String calinterest_mode) {
        this.cal_interest_mode = calinterest_mode;
    }

    public String getPay_interest_frequency() {
        return this.pay_interest_frequency;
    }

    public void setPay_interest_frequency(String pay_interest_frequency) {
        this.pay_interest_frequency = pay_interest_frequency;
    }

    public String getBond_issue_uplimit() {
        return this.bond_issue_uplimit;
    }

    public void setBond_issue_uplimit(String bond_issue_uplimit) {
        this.bond_issue_uplimit = bond_issue_uplimit;
    }

    public String getBond_issue_lowlimit() {
        return this.bond_issue_lowlimit;
    }

    public void setBond_issue_lowlimit(String bond_issue_lowlimit) {
        this.bond_issue_lowlimit = bond_issue_lowlimit;
    }

    public String getBond_change_unit() {
        return this.bond_change_unit;
    }

    public void setBond_change_unit(String bond_change_unit) {
        this.bond_change_unit = bond_change_unit;
    }

    public String getIssue_date() {
        return this.issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getBegin_cal_interest_date() {
        return this.begin_cal_interest_date;
    }

    public void setBegin_cal_interest_date(String begin_calinterest_date) {
        this.begin_cal_interest_date = begin_calinterest_date;
    }

    public String getInitial_sep_sell_date() {
        return this.initial_sep_sell_date;
    }

    public void setInitial_sep_sell_date(String initial_sepsell_date) {
        this.initial_sep_sell_date = initial_sepsell_date;
    }

    public String getEnd_sep_sell_date() {
        return this.end_sep_sell_date;
    }

    public void setEnd_sep_sell_date(String end_sepsell_date) {
        this.end_sep_sell_date = end_sepsell_date;
    }

    public String getMarket_circulating_date() {
        return this.market_circulating_date;
    }

    public void setMarket_circulating_date(String maket_circulating_date) {
        this.market_circulating_date = maket_circulating_date;
    }

    public String getCash_date() {
        return this.cash_date;
    }

    public void setCash_date(String cash_date) {
        this.cash_date = cash_date;
    }

    public String getBefpay_altertrust_stopdays() {
        return this.befpay_altertrust_stopdays;
    }

    public void setBefpay_altertrust_stopdays(String befpay_altertrust_stopdays) {
        this.befpay_altertrust_stopdays = befpay_altertrust_stopdays;
    }

    public String getBefpay_bond_registerdays() {
        return this.befpay_bond_registerdays;
    }

    public void setBefpay_bond_registerdays(String befpay_bond_registerdays) {
        this.befpay_bond_registerdays = befpay_bond_registerdays;
    }

    public String getClose_transfer_days() {
        return this.close_transfer_days;
    }

    public void setClose_transfer_days(String close_transfer_days) {
        this.close_transfer_days = close_transfer_days;
    }

    public String getConsign_quantum() {
        return this.consign_quantum;
    }

    public void setConsign_quantum(String consign_quantum) {
        this.consign_quantum = consign_quantum;
    }

    public String getIssue_price() {
        return this.issue_price;
    }

    public void setIssue_price(String issue_price) {
        this.issue_price = issue_price;
    }

    public String getBefCashDay_OutRequest_stopdays() {
        return this.befCashDay_OutRequest_stopdays;
    }

    public void setBefCashDay_OutRequest_stopdays(String befCashDay_OutRequest_stopdays) {
        this.befCashDay_OutRequest_stopdays = befCashDay_OutRequest_stopdays;
    }

    public String getCal_interest_norm() {
        return this.cal_interest_norm;
    }

    public void setCal_interest_norm(String calinterest_norm) {
        this.cal_interest_norm = calinterest_norm;
    }
 
}
