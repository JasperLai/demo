package com.example.demo.business.trade.infrastructure.repository;

import com.example.demo.business.trade.domain.entity.AccountingEntry;
import com.example.demo.business.trade.infrastructure.mapper.AccountingMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class AccountingRepositoryImplTest {

    @Mock
    private AccountingMapper accountingMapper;

    @InjectMocks
    private AccountingRepositoryImpl accountingRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save_ShouldCallMapperInsert() {
        // given
        AccountingEntry accounting = createTestAccounting();

        // when
        accountingRepository.save(accounting);

        // then
        verify(accountingMapper).insert(accounting);
    }

    @Test
    void findByTxTraceNum_ShouldReturnAccounting() {
        // given
        String txTraceNum = "TX123456";
        AccountingEntry expected = createTestAccounting();
        when(accountingMapper.selectByTxTraceNum(txTraceNum)).thenReturn(expected);

        // when
        AccountingEntry actual = accountingRepository.findByTxTraceNum(txTraceNum);

        // then
        assertNotNull(actual);
        assertEquals(expected.getTxTraceNum(), actual.getTxTraceNum());
        assertEquals(expected.getTxAmt(), actual.getTxAmt());
    }

    @Test
    void findByInitTxTraceNum_ShouldReturnAccounting() {
        // given
        String initTxTraceNum = "INIT123456";
        AccountingEntry expected = createTestAccounting();
        when(accountingMapper.selectByInitTxTraceNum(initTxTraceNum)).thenReturn(expected);

        // when
        AccountingEntry actual = accountingRepository.findByInitTxTraceNum(initTxTraceNum);

        // then
        assertNotNull(actual);
        assertEquals(expected.getInitTxTraceNum(), actual.getInitTxTraceNum());
    }

    @Test
    void update_ShouldCallMapperUpdate() {
        // given
        AccountingEntry accounting = createTestAccounting();

        // when
        accountingRepository.update(accounting);

        // then
        verify(accountingMapper).update(accounting);
    }

    private AccountingEntry createTestAccounting() {
        AccountingEntry accounting = new AccountingEntry();
        accounting.setTxTraceNum("TX123456");
        accounting.setInitTxTraceNum("INIT123456");
        accounting.setTxAmt(new BigDecimal("100.00"));
        accounting.setTxDt(new Date());
        return accounting;
    }
} 