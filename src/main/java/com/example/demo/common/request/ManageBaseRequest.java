package com.example.demo.common.request;

public class ManageBaseRequest {

    private String trans_operator_id;
    private String trans_dep;
    private String front_trans_id;
    private String trans_channel;
    private String operate_code;

    public String getTrans_operator_id() {
        return trans_operator_id;
    }

    public void setTrans_operator_id(String trans_operator_id) {
        this.trans_operator_id = trans_operator_id;
    }

    public String getTrans_dep() {
        return trans_dep;
    }

    public void setTrans_dep(String trans_dep) {
        this.trans_dep = trans_dep;
    }

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

    public String getOperate_code() {
        return operate_code;
    }

    public void setOperate_code(String operate_code) {
        this.operate_code = operate_code;
    }
}

