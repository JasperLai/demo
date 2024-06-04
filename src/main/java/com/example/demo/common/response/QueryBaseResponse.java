package com.example.demo.common.response;

import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.util.DateUtil;
import com.github.pagehelper.PageInfo;

public class QueryBaseResponse {
    private String trade_date;
    private String trade_time;
    private String domain;
    private String type;
    private String code;
    private String message;
    private String externalsystem;
    private String externalcode;
    private String externalMessage;
    private int low_index;//当前页起始序号
    private int hight_index;//当前页结束序号
    private long all_size;//总记录数
    private int all_page_size;//总页数
    private int view_index;//当前页码
    private int view_size;//页大小

    

    public QueryBaseResponse() {
        this.trade_date = DateUtil.getCurrentDate();
        this.trade_time = DateUtil.getCurrentDateTime();
    }

    public QueryBaseResponse(BaseData inv) {
        this.trade_date = DateUtil.getCurrentDate();
        this.trade_time = DateUtil.getCurrentDateTime();
        this.setCode(inv.getErrCode());
        this.setMessage(inv.getReturnMsg());
        this.setType(BaseData.mapType(inv.isSuccess()));
    }

    @SuppressWarnings("rawtypes")
    public void initPageInfo(PageInfo page){
        this.low_index = (int)page.getStartRow();
        this.hight_index = (int)page.getEndRow();
        this.all_size = (int)page.getTotal();
        this.all_page_size = page.getPages();
        this.view_index = page.getPageNum();
        this.view_size = page.getPageSize();
    }


    public String getTrade_date() {
        return this.trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }

    public String getTrade_time() {
        return this.trade_time;
    }

    public void setTrade_time(String trade_time) {
        this.trade_time = trade_time;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExternalsystem() {
        return this.externalsystem;
    }

    public void setExternalsystem(String externalsystem) {
        this.externalsystem = externalsystem;
    }

    public String getExternalcode() {
        return this.externalcode;
    }

    public void setExternalcode(String externalcode) {
        this.externalcode = externalcode;
    }

    public String getExternalMessage() {
        return this.externalMessage;
    }

    public void setExternalMessage(String externalMessage) {
        this.externalMessage = externalMessage;
    }

    public int getLow_index() {
        return this.low_index;
    }

    public void setLow_index(int low_index) {
        this.low_index = low_index;
    }

    public int getHight_index() {
        return this.hight_index;
    }

    public void setHight_index(int hight_index) {
        this.hight_index = hight_index;
    }

    public long getAll_size() {
        return this.all_size;
    }

    public void setAll_size(long all_size) {
        this.all_size = all_size;
    }

    public int getAll_page_size() {
        return this.all_page_size;
    }

    public void setAll_page_size(int all_page_size) {
        this.all_page_size = all_page_size;
    }

    public int getView_index() {
        return this.view_index;
    }

    public void setView_index(int view_index) {
        this.view_index = view_index;
    }

    public int getView_size() {
        return this.view_size;
    }

    public void setView_size(int view_size) {
        this.view_size = view_size;
    }


}
