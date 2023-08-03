package com.example.demo.model.Report.type;

public enum TranscChnl {
    BANK_COUNTER("01", "银行柜面"),
    INTERNET_BANKING("02", "网银"),
    MOBILE_BANKING("03", "手机银行"),
    PHONE_BANKING("04", "电话银行"),
    ATM("05", "ATM"),
    WECHAT_BANKING("06", "微信银行"),
    COMMUNITY_BANK("07", "社区银行"),
    HOME_BANK("08", "家居银行"),
    OTHER("09", "其他");

    private final String code;
    private final String value;

    TranscChnl(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString(){
        return value;
    }


    public static TranscChnl fromCode(String code) {
        for (TranscChnl channel : TranscChnl.values()) {
            if (channel.code.equals(code)) {
                return channel;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

}

