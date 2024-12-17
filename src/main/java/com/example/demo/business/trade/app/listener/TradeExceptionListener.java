package com.example.demo.business.trade.app.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.demo.business.trade.domain.service.OrderService;
import com.example.demo.business.customer.client.CustomerPositionService;
import com.example.demo.common.event.PaymentTimeoutEvent;
import com.example.demo.common.event.PaymentFailureEvent;
import com.example.demo.business.trade.domain.entity.Order;

@Component
public class TradeExceptionListener {
    
    private static final Logger log = LogManager.getLogger(TradeExceptionListener.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerPositionService customerPositionService;

    @EventListener
    public void handlePaymentTimeout(PaymentTimeoutEvent event) {
        String txTraceNum = event.getTxTraceNum();
        Order order = orderService.getOrderByTraceNum(txTraceNum);
        
        log.error("支付超时异常: orderId={}, customerId={}, isTimeout={}, isConnectionReset={}, isConnectionRefused={}", 
            txTraceNum,
            event.isTimeout(),
            event.isConnectionReset(),
            event.isConnectionRefused()
        );

        if (event.isConnectionRefused()) {
            // 连接被拒绝，可能是支付网关服务不可用
            orderService.markOrderAsFailed(txTraceNum, "支付服务暂时不可用，请稍后重试");
            // 可能需要通知运维
            // notifyOperations("支付网关无法连接");
            return;
        }

        // 1. 将订单状态改为处理中
        orderService.markOrderAsProcessing(txTraceNum);

        // 2. 锁定客户相关资产
        // customerPositionService.lockCustomerPosition(order.getCustomerId());

        // 3. 发起异步查询支付状态
        orderService.schedulePaymentStatusCheck(txTraceNum);
    }

    @EventListener
    public void handlePaymentFailure(PaymentFailureEvent event) {
        String txTraceNum = event.getTxTraceNum();
        // 从数据库获取订单信息
        Order order = orderService.getOrderByTraceNum(txTraceNum);
        
        log.error("支付失败: orderId={}, customerId={}, reason={}", 
            txTraceNum,
            event.getException().getMessage()
        );

        // 1. 将订单状态改为支付失败
        orderService.markOrderAsFailed(txTraceNum, event.getException().getMessage());

        // 2. 解锁客户资产
        // customerPositionService.unlockCustomerPosition(order.getCustomerId());

        // 3. 发送支付失败通知
        orderService.notifyPaymentFailure(txTraceNum);
    }
} 