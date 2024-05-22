package com.example.demo.business.product.domain.domainObject;

import java.util.EnumMap;
import java.util.Map;

public class BondBusinessAuth {
    private int permissions;
    private String bondCode;

    // 交易类型枚举，新增 ALL_TRANSACTIONS 总开关
    public enum TransactionType {
        ALL_TRANSACTIONS,
        BUY_SELL,
        TRANSFER,
        NON_TRADE_TRANSFER,
        INTEREST_PAYMENT,
        REDEMPTION
    }

    // 映射关系，为总开关分配最高位掩码
    private static final Map<TransactionType, Integer> TRANSACTION_TYPE_MASK_MAP = new EnumMap<>(TransactionType.class);

    static {
        //0b1111111 第一位位产品宗凯
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.ALL_TRANSACTIONS, 0b1000000); // 产品总开关
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.BUY_SELL, 0b0000001); //交易开关
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.TRANSFER, 0b0000010); //转托管开关
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.NON_TRADE_TRANSFER, 0b0000100); //非交易过户开关
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.INTEREST_PAYMENT, 0b0001000); //付息开关
        TRANSACTION_TYPE_MASK_MAP.put(TransactionType.REDEMPTION, 0b0010000); //兑付开关
    }

    public BondBusinessAuth(int permissions) {
        this.permissions = permissions;
    }

    public BondBusinessAuth() {
        // 将所有权限位初始化为1，表示所有权限默认打开
        this.permissions = 0b111111; 
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

    public boolean canExectute(TransactionType type){
        // 首先检查总开关是否开启
        boolean isAllTransactionsEnabled = (permissions & TRANSACTION_TYPE_MASK_MAP.get(TransactionType.ALL_TRANSACTIONS)) != 0;
        if (!isAllTransactionsEnabled) {
            return false; // 如果总开关关闭，则直接返回false，表示不允许执行任何交易
        }
        // 如果总开关开启，再根据细分权限进行判断
        return (permissions & TRANSACTION_TYPE_MASK_MAP.get(type)) != 0;
    }
    

    public void disable(TransactionType transactionType) {
        if (TRANSACTION_TYPE_MASK_MAP.containsKey(transactionType)) {
            int mask = TRANSACTION_TYPE_MASK_MAP.get(transactionType);
            permissions &= ~mask; //将指定位置设置为0
        } else {
            System.out.println("无效的交易类型。");
        }
    }

    public void enable(TransactionType transactionType) {
        if (TRANSACTION_TYPE_MASK_MAP.containsKey(transactionType)) {
            int mask = TRANSACTION_TYPE_MASK_MAP.get(transactionType);
            permissions |= mask; // 将指定位置为1，其他位置保持不变
        } else {
            System.out.println("无效的交易类型。");
        }
    }

    // 新增方法：禁用所有交易
    public void disableAllTransactions() {
        permissions &= ~TRANSACTION_TYPE_MASK_MAP.get(TransactionType.ALL_TRANSACTIONS); // 关闭总开关
    }

    // 新增方法：启用所有交易
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

    //将二进制数据转换位 int
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
        if (auth.canExectute(TransactionType.BUY_SELL)) {
            System.out.println("可以进行买入卖出操作。");
        } else {
            System.out.println("禁止买入卖出操作。");
        }

        // 关闭所有交易权限
        auth.disableAllTransactions();
        System.out.println("After Disabling All Transactions: " + auth.getPermissionsAsBinaryString());
    }
}
