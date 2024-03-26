package com.example.demo.business.product.domain.domainObject;

import java.util.EnumMap;
import java.util.Map;

public class BondBusinessAuth {
    private int permissions;
    private String bondCode;
    private String saleArea;

    // 交易类型枚举
    public enum TransactionType {
        BUY_SELL,
        TRANSFER,
        NON_TRADE_TRANSFER,
        INTEREST_PAYMENT,
        REDEMPTION
    }

    // 映射关系
    private static final Map<TransactionType, Integer> TRANSACTION_TYPE_MASK_MAP = new EnumMap<>(TransactionType.class);

    static {
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.BUY_SELL, 0b00001);
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.TRANSFER, 0b00010);
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.NON_TRADE_TRANSFER, 0b00100);
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.INTEREST_PAYMENT, 0b01000);
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.REDEMPTION, 0b10000);
    }

    public BondBusinessAuth(int permissions) {
        this.permissions = permissions;
    }

    public String getBondCode() {
        return this.bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public int getPermissions() {
        return permissions;
    }


    public boolean canExectute(TransactionType type){
        return (permissions & TRANSACTION_TYPE_MASK_MAP.get(type)) == 0;
    }

    public void disable(TransactionType transactionType) {
        if (TRANSACTION_TYPE_MASK_MAP.containsKey(transactionType)) {
            int mask = TRANSACTION_TYPE_MASK_MAP.get(transactionType);
            permissions |= mask;
        } else {
            System.out.println("无效的交易类型。");
        }
    }

    public void enable(TransactionType transactionType) {
        if (TRANSACTION_TYPE_MASK_MAP.containsKey(transactionType)) {
            int mask = TRANSACTION_TYPE_MASK_MAP.get(transactionType);
            permissions &= ~mask; // 将指定位置为 0，其他位置保持不变
        } else {
            System.out.println("无效的交易类型。");
        }
    }

    public static void main(String[] args) {
        // 示例用法
        BondBusinessAuth auth = new BondBusinessAuth(0); // 初始权限全部允许

        // 禁止买入卖出操作
        auth.disable(TransactionType.INTEREST_PAYMENT);

        // 输出当前权限
        System.out.println("Current Permissions: " + auth.getPermissions());

        // 检查是否允许买入卖出操作
        if (auth.canExectute(TransactionType.INTEREST_PAYMENT)) {
            System.out.println("可以进行买入卖出操作。");
        } else {
            System.out.println("禁止买入卖出操作。");
        }
    }
}
