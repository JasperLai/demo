package com.example.demo.business.trade.infrastructure.repository;

import com.example.demo.business.trade.domain.entity.PeOrder;
import com.example.demo.business.trade.infrastructure.mapper.PeOrderMapper;
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

class PeOrderRepositoryImplTest {

    @Mock
    private PeOrderMapper peOrderMapper;

    @InjectMocks
    private PeOrderRepositoryImpl peOrderRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save_ShouldCallMapperInsert() {
        // given
        PeOrder peOrder = createTestPeOrder();

        // when
        peOrderRepository.save(peOrder);

        // then
        verify(peOrderMapper).insert(peOrder);
    }

    @Test
    void findByTxTraceNum_ShouldReturnPeOrder() {
        // given
        String txTraceNum = "TX123456";
        PeOrder expected = createTestPeOrder();
        when(peOrderMapper.selectByTxTraceNum(txTraceNum)).thenReturn(expected);

        // when
        PeOrder actual = peOrderRepository.findByTxTraceNum(txTraceNum);

        // then
        assertNotNull(actual);
        assertEquals(expected.getTxTraceNum(), actual.getTxTraceNum());
        assertEquals(expected.getTxAnt(), actual.getTxAnt());
    }

    @Test
    void findByPeOrderNum_ShouldReturnPeOrder() {
        // given
        String peOrderNum = "PE123456";
        PeOrder expected = createTestPeOrder();
        when(peOrderMapper.selectByPeOrderNum(peOrderNum)).thenReturn(expected);

        // when
        PeOrder actual = peOrderRepository.findByPeOrderNum(peOrderNum);

        // then
        assertNotNull(actual);
        assertEquals(expected.getPeOrderNum(), actual.getPeOrderNum());
    }

    @Test
    void update_ShouldCallMapperUpdate() {
        // given
        PeOrder peOrder = createTestPeOrder();

        // when
        peOrderRepository.update(peOrder);

        // then
        verify(peOrderMapper).update(peOrder);
    }

    private PeOrder createTestPeOrder() {
        PeOrder peOrder = new PeOrder();
        peOrder.setTxTraceNum("TX123456");
        peOrder.setPeOrderNum("PE123456");
        peOrder.setTxAnt(new BigDecimal("100.00"));
        peOrder.setTxDt(new Date());
        return peOrder;
    }
} 