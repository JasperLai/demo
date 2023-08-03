package com.example.demo.model.Report.NodeImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.demo.Log4j2Example;
import com.example.demo.model.Report.Node;
import com.example.demo.model.Report.type.CommonDate;
import com.example.demo.model.Report.type.ExactNText;
import com.example.demo.model.Report.type.MaxNText;
import com.example.demo.model.Report.type.TranscChnl;

public class OpenAccountNode extends Node {

    private CommonDate openAccountDate;
    private MaxNText idCardNo;
    private ExactNText accountNo;
    private TranscChnl openAccountChannel;
    private static final Logger logger = LogManager.getLogger(OpenAccountNode.class);

    public static void main(String[] args) {
        OpenAccountNode a = new OpenAccountNode("20230812", "12345678998765432100", "000011112222333345", "01");
        // logger.info(a.getValue());
        System.out.println(a.getValue());
    }

    public OpenAccountNode(String openAccountDate, String idCardNo, String accountNo,
            String openAccountChannel) {

        this.openAccountDate = new CommonDate(openAccountDate);
        this.idCardNo = new MaxNText(20, idCardNo);
        this.accountNo = new ExactNText(18, accountNo);
        this.openAccountChannel = TranscChnl.fromCode(openAccountChannel);
    }

    public CommonDate getOpenAccountDate() {
        return openAccountDate;
    }

    public MaxNText getIdCardNo() {
        return idCardNo;
    }

    public ExactNText getAccountNo() {
        return accountNo;
    }

    public TranscChnl getOpenAccountChannel() {
        return openAccountChannel;
    }

    public void setOpenAccountChannel(TranscChnl openAccountChannel) {
        this.openAccountChannel = openAccountChannel;
    }

    @Override
    public String getValue() {
        StringBuffer sb = new StringBuffer().append(openAccountDate).append(getDelimiter())
                .append(accountNo).append(getDelimiter())
                .append(idCardNo).append(getDelimiter())
                .append(openAccountChannel.getCode());
        return sb.toString();
    }

}
