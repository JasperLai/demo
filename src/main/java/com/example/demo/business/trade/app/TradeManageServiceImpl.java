package com.example.demo.business.trade.app;

import com.example.demo.business.trade.client.TradeManageService;
import com.example.demo.business.trade.client.request.BondSellRequest;
import com.example.demo.business.trade.client.request.SubscriptionRequest;
import com.example.demo.business.trade.client.request.queryTradeRequest;
import com.example.demo.business.trade.client.request.queryVolRequest;
import com.example.demo.business.trade.client.response.QueryTradeResponse;
import com.example.demo.business.trade.client.response.QueryVolumeResponse;

public class TradeManageServiceImpl implements TradeManageService{

    @Override
    public void processBondSubscription(SubscriptionRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processBondSubscription'");
    }

    @Override
    public void processBondSell(BondSellRequest dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processBondSell'");
    }

    @Override
    public void cancelTrade(String transNum) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelTrade'");
    }

    @Override
    public QueryTradeResponse queryTradeDetail(queryTradeRequest dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryTradeDetail'");
    }

    @Override
    public QueryVolumeResponse queryTradingVolume(queryVolRequest dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryTradingVolume'");
    }

    @Override
    public void payInterestInBatch(String bondCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'payInterestInBatch'");
    }

    @Override
    public void redeemBondsInBatch(String bondCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redeemBondsInBatch'");
    }

    @Override
    public void processInterestRedemptionErrors(String peOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processInterestRedemptionErrors'");
    }

}
