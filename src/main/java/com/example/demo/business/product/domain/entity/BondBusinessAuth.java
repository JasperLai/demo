package com.example.demo.business.product.domain.entity;

import java.util.EnumMap;
import java.util.Map;

/**
 * 债券业务权限控制类
 * 使用位运算实现高效的权限管理，包含总开关和各项具体业务权限
 */
public class BondBusinessAuth {
    /** 权限位图，使用整型的每一位表示不同权限的开关状态 */
    private int permissions;
    /** 债券代码 */
    private String bondCode;

    /**
     * 交易类型枚举
     * ALL_TRANSACTIONS: 总开关，控制所有交易权限
     * BUY_SELL: 买卖交易权限
     * TRANSFER: 转托管权限
     * NON_TRADE_TRANSFER: 非交易过户权限
     * INTEREST_PAYMENT: 付息权限
     * REDEMPTION: 兑付权限
     */
    public enum TransactionType {
        ALL_TRANSACTIONS,
        BUY_SELL,
        TRANSFER,
        NON_TRADE_TRANSFER,
        INTEREST_PAYMENT,
        REDEMPTION
    }

    /** 交易类型与权限位掩码的映射关系 */
    private static final Map<TransactionType, Integer> TRANSACTION_TYPE_MASK_MAP = new EnumMap<>(TransactionType.class);

    static {
        // 初始化权限掩码映射
        // 使用二进制位表示不同权限，第7位(最高位)为总开关
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.ALL_TRANSACTIONS, 0b1000000); // 第7位：总开关
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.BUY_SELL,        0b0000001); // 第1位：交易权限
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.TRANSFER,        0b0000010); // 第2位：转托管权限
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.NON_TRADE_TRANSFER, 0b0000100); // 第3位：非交易过户权限
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.INTEREST_PAYMENT,   0b0001000); // 第4位：付息权限
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.REDEMPTION,         0b0010000); // 第5位：兑付权限
    }

    /**
     * 检查指定交易类型是否允许执行
     * @param type 要检查的交易类型
     * @return 如果允许执行返回true，否则返回false
     */
    public boolean canExecute(TransactionType type){
        // 首先检查总开关是否开启
        boolean isAllTransactionsEnabled = (permissions & TRANSACTION_TYPE_MASK_MAP.get(TransactionType.ALL_TRANSACTIONS)) != 0;
        if (!isAllTransactionsEnabled) {
            return false;
        }
        // 再检查具体权限位
        return (permissions & TRANSACTION_TYPE_MASK_MAP.get(type)) != 0;
    }

    /**
     * 禁用指定的交易类型
     * @param transactionType 要禁用的交易类型
     */
    public synchronized void disable(TransactionType transactionType) {
        if (!TRANSACTION_TYPE_MASK_MAP.containsKey(transactionType)) {
            throw new IllegalArgumentException("Invalid transaction type: " + transactionType);
        }
        int mask = TRANSACTION_TYPE_MASK_MAP.get(transactionType);
        permissions &= ~mask; // 将指定位置设为0
    }

    /**
     * 启用指定的交易类型
     * @param transactionType 要启用的交易类型
     */
    public synchronized void enable(TransactionType transactionType) {
        if (!TRANSACTION_TYPE_MASK_MAP.containsKey(transactionType)) {
            throw new IllegalArgumentException("Invalid transaction type: " + transactionType);
        }
        int mask = TRANSACTION_TYPE_MASK_MAP.get(transactionType);
        permissions |= mask; // 将指定位置设为1
    }

    /**
     * 获取所有权限的当前状态
     * @return 返回一个Map，键为交易类型，值为该类型是否启用
     */
    public Map<TransactionType, Boolean> getAllPermissionStatus() {
        Map<TransactionType, Boolean> status = new EnumMap<>(TransactionType.class);
        for (TransactionType type : TransactionType.values()) {
            status.put(type, canExecute(type));
        }
        return status;
    }

    public BondBusinessAuth(int permissions) {
        this.permissions = permissions;
    }

    public BondBusinessAuth() {
        // 包含总开关在内的所有权限默认开启
        this.permissions = 0b1111111; 
    }
    
    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public int getPermissions() {
        return permissions;
    }

    public String getBondCode(){
        return bondCode;
    }

    public void disableAllTransactions() {
        permissions &= ~TRANSACTION_TYPE_MASK_MAP.get(TransactionType.ALL_TRANSACTIONS); // 关闭总开关
    }

    public void enableAllTransactions() {
        permissions |= TRANSACTION_TYPE_MASK_MAP.get(TransactionType.ALL_TRANSACTIONS); // 打开总开关
    }

    //将 permission转换位二进制字符串
    public String getPermissionsAsBinaryString() {
        // 将permissions转换为二进制字符串
        String binaryString = Integer.toBinaryString(permissions);
        // 确保字符串长度为7位，前面填充0
        while (binaryString.length() < 6) {
            binaryString = "0" + binaryString;
        }
        return binaryString;
    }

    //将二进数据转换位 int
    public void setPermissionsFromBinaryString(String binaryString) {
        // 将二进制字符串转换为整型
        permissions = Integer.parseInt(binaryString, 2);
    }
    

    public static void main(String[] args) {
        // 示例用法
        BondBusinessAuth auth = new BondBusinessAuth();

        auth.disableAllTransactions(); // 打开所有交易权限
        auth.disable(TransactionType.BUY_SELL);
        auth.enableAllTransactions();
        System.out.println("Current Permissions: " + auth.getPermissionsAsBinaryString());

        // 检查是否允许特定操作
        if (auth.canExecute(TransactionType.BUY_SELL)) {
            System.out.println("可以进行买入卖出操作。");
        } else {
            System.out.println("禁止买入卖出操作。");
        }

        // 关闭所有交易权限
        auth.disableAllTransactions();
        System.out.println("After Disabling All Transactions: " + auth.getPermissionsAsBinaryString());
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }
}
