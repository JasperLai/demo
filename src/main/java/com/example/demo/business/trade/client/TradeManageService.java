package com.example.demo.business.trade.client;

import com.example.demo.business.trade.client.request.BondSellRequest;
import com.example.demo.business.trade.client.request.SubscriptionRequest;
import com.example.demo.business.trade.client.request.queryTradeRequest;
import com.example.demo.business.trade.client.request.queryVolRequest;
import com.example.demo.business.trade.client.response.QueryTradeResponse;
import com.example.demo.business.trade.client.response.QueryVolumeResponse;


/**
 * 应用层服务， 对应实现XMIND的接口图功能
 */
public interface TradeManageService {
    //客户债券买入
    void processBondSubscription(SubscriptionRequest  request);

    //客户债券卖出
    void processBondSell(BondSellRequest dto);

    //抹账交易
    void cancelTrade(String transNum);

    //交易明细查询
    QueryTradeResponse queryTradeDetail(queryTradeRequest dto);

    //交易量查询
    QueryVolumeResponse queryTradingVolume(queryVolRequest dto);

    //批量付息
    void payInterestInBatch(String bondCode);

    //批量兑付
    void redeemBondsInBatch(String bondCode);

    //付息兑付异常单笔处理
    void processInterestRedemptionErrors(String peOrder);

}

