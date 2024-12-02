package com.example.demo.business.trade.infrastructure.repository;

import com.example.demo.business.trade.domain.entity.Order;
import com.example.demo.business.trade.infrastructure.mapper.OrdersMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryImplTest {

    @Mock
    private OrdersMapper ordersMapper;

    @InjectMocks
    private OrderRepositoryImpl orderRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save_ShouldCallMapperInsert() {
        // given
        Order order = createTestOrder();

        // when
        orderRepository.save(order);

        // then
        verify(ordersMapper).insert(order);
    }

    @Test
    void findByTxTraceNum_ShouldReturnOrder() {
        // given
        String txTraceNum = "TX123456";
        Order expected = createTestOrder();
        when(ordersMapper.selectByTxTraceNum(txTraceNum)).thenReturn(expected);

        // when
        Order actual = orderRepository.findByTxTraceNum(txTraceNum);

        // then
        assertNotNull(actual);
        assertEquals(expected.getTxTraceNum(), actual.getTxTraceNum());
        assertEquals(expected.getTxMnt(), actual.getTxMnt());
    }

    @Test
    void findByTradeAcc_ShouldReturnOrderList() {
        // given
        String tradeAcc = "ACC123";
        List<Order> expected = Arrays.asList(createTestOrder(), createTestOrder());
        when(ordersMapper.selectByTradeAcc(tradeAcc)).thenReturn(expected);

        // when
        List<Order> actual = orderRepository.findByTradeAcc(tradeAcc);

        // then
        assertNotNull(actual);
        assertEquals(2, actual.size());
    }

    @Test
    void findByBondCode_ShouldReturnOrderList() {
        // given
        String bondCode = "BOND123";
        List<Order> expected = Arrays.asList(createTestOrder(), createTestOrder());
        when(ordersMapper.selectByBondCode(bondCode)).thenReturn(expected);

        // when
        List<Order> actual = orderRepository.findByBondCode(bondCode);

        // then
        assertNotNull(actual);
        assertEquals(2, actual.size());
    }

    private Order createTestOrder() {
        Order order = new Order();
        order.setTxTraceNum("TX123456");
        order.setBondCode("BOND123");
        order.setTradeAcc("ACC123");
        order.setTxMnt(new BigDecimal("1000.00"));
        order.setTxDt(new Date());
        return order;
    }
} 