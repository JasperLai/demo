package com.example.demo.business.general.app;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.general.client.TMSInterface;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.general.client.TransStatus;
import com.example.demo.business.general.app.dto.TransactionDTO;
import com.example.demo.business.general.domain.entity.Transaction;
import com.example.demo.business.general.infrastructure.mapper.TransactionMapper;

@Service
public class TransactionManageService implements TMSInterface {
    
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public String createTransaction(TransactionDTO dto, TradeType type) {
        // 生成系统流水号
        String txTraceNum = generateTraceNum();
        
        // 构建Transaction实体
        Transaction transaction = new Transaction();
        transaction.setTxTraceNum(txTraceNum);
        transaction.setInitTxTraceNum(dto.getInitTxTraceNum());
        transaction.setChannelNo(dto.getChannelNo());
        transaction.setTxIntOrgNum(dto.getTxIntOrgNum());
        transaction.setTellerNo(dto.getTellerNo());
        transaction.setTradeType(type.getCode());
        transaction.setTradeAcc(dto.getTradeAcc());
        transaction.setBusinessDate(dto.getBusinessDate());
        transaction.setTradeTime(dto.getTradeTime());
        transaction.setUpdateTime(LocalDateTime.now());
        transaction.setStatus("1"); // 初始状态
        transaction.setRemark(dto.getRemark());
        
        // 保存交易流水
        transactionMapper.insert(transaction);
        
        return txTraceNum;
    }

    @Override
    public TransactionDTO query(String transactionNo) {
        Transaction transaction = transactionMapper.selectByTraceNum(transactionNo);
        return convertToDTO(transaction);
    }

    @Override
    public boolean updateTransaction(String transactionNo, TransStatus status) {
        return transactionMapper.updateStatus(transactionNo, String.valueOf(status.getCode())) > 0;
    }
    
    private String generateTraceNum() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    private TransactionDTO convertToDTO(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        TransactionDTO dto = new TransactionDTO();
        dto.setTxTraceNum(transaction.getTxTraceNum());
        dto.setInitTxTraceNum(transaction.getInitTxTraceNum());
        dto.setChannelNo(transaction.getChannelNo());
        dto.setTxIntOrgNum(transaction.getTxIntOrgNum());
        dto.setTellerNo(transaction.getTellerNo());
        dto.setTradeType(transaction.getTradeType());
        dto.setTradeAcc(transaction.getTradeAcc());
        dto.setBusinessDate(transaction.getBusinessDate());
        dto.setTradeTime(transaction.getTradeTime());
        dto.setStatus(transaction.getStatus());
        dto.setRemark(transaction.getRemark());
        return dto;
    }
}
