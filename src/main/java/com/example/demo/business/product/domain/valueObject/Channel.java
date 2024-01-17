package com.example.demo.business.product.domain.valueObject;

public enum Channel {
    XBANK("1101", "柜面"),
    NETBANK("1102", "网银"),
    CELLPHONE("1103", "手机银行");

    private final String value;
    private final String displayName;

    Channel(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public String getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static String getDisplayName(String id) {
        for (Channel ChannelId : Channel.values()) {
            if (ChannelId.getValue() == id) {
                return ChannelId.getDisplayName();
            }
        }
        return null;
    }
}
