package com.example.demo.business.product.domain.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.business.product.domain.domainObject.Inventory;
import com.example.demo.business.product.domain.domainObject.Trader;
import com.example.demo.business.product.repository.InventoryRepo;
import com.example.demo.business.product.repository.TraderRepo;
@Component
public class ChannelService {
    private static final Logger logger = LogManager.getLogger(ChannelService.class);

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private TraderRepo tradeRepo;


    /**
     * 可用交易商查询
     * @param custodyID
     * @return
     */
    public List<Trader> getTraderList(String custodyID){
        return null;
    }

    /**
     * 交易商录入
     * @param tlist
     */
    public void importTraderList(List<Trader> tlist){

    }


}
