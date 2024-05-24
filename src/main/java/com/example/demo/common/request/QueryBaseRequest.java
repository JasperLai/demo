package com.example.demo.common.request;

public class QueryBaseRequest {
    private String front_trans_id;// 前置流水号
    private String trans_channel;// 交易渠道
    private String trans_dep;// 交易机构
    private String trans_operator_id;// 交易柜员
    private String accredit_id;// 授权柜员号
    private String operate_code;// 服务编码
    private String view_index;// 页号
    private String view_size;// 页大小
    
    public String getFront_trans_id() {
        return front_trans_id;
    }
    public void setFront_trans_id(String front_trans_id) {
        this.front_trans_id = front_trans_id;
    }
    public String getTrans_channel() {
        return trans_channel;
    }
    public void setTrans_channel(String trans_channel) {
        this.trans_channel = trans_channel;
    }
    public String getTrans_dep() {
        return trans_dep;
    }
    public void setTrans_dep(String trans_dep) {
        this.trans_dep = trans_dep;
    }
    public String getTrans_operator_id() {
        return trans_operator_id;
    }
    public void setTrans_operator_id(String trans_operator_id) {
        this.trans_operator_id = trans_operator_id;
    }
    public String getAccredit_id() {
        return accredit_id;
    }
    public void setAccredit_id(String accredit_id) {
        this.accredit_id = accredit_id;
    }
    public String getOperate_code() {
        return operate_code;
    }
    public void setOperate_code(String operate_code) {
        this.operate_code = operate_code;
    }
    public String getView_index() {
        return view_index;
    }
    public void setView_index(String view_index) {
        this.view_index = view_index;
    }
    public String getView_size() {
        return view_size;
    }
    public void setView_size(String view_size) {
        this.view_size = view_size;
    }
}
