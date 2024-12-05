package com.example.demo.business.general.client;

import com.example.demo.business.general.app.dto.TransactionDTO;

/**
 * 统一流水登记
 */
public interface TMSInterface {

    /**
     * 创建交易流水
     * @param dto 交易流水数据
     * @param type 交易类型
     * @return 系统流水号
     */
    public String createTransaction(TransactionDTO dto, TradeType type);

    /**
     * 查询交易流水
     * @param transactionNo 系统流水号
     * @return 交易流水数据
     */
    public TransactionDTO query(String transactionNo);

    /**
     * 更新交易状态
     * @param transactionNo 系统流水号
     * @param status 交易状态
     * @return 是否更新成功
     */
    public boolean updateTransaction(String transactionNo, TransStatus status);

}
