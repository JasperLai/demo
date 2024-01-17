package com.example.demo.business.product.domain.domainObject;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.demo.business.product.domain.valueObject.Channel;
import com.example.demo.business.product.repository.dto.ChangeQuotationDto;

import java.util.HashMap;

public class Inventory {
    private static final Logger logger = LogManager.getLogger(Inventory.class);

    private Map<String, Map<String, Integer>> channelInventory; // map<channelid， map<bondCode, quantity>>


    public void setChannelInventory(Map<String,Map<String,Integer>> channelInventory) {
        this.channelInventory = channelInventory;
    }

    public Inventory() {
        this.channelInventory = new HashMap<>();
    }

    // 初始化债券可售额度
    public void initializeInventory(ChangeQuotationDto dto) {
        String channelId = dto.getChannelId();
        String bond = dto.getBondCode();
        int quantity = dto.getChangeQuantity();
        channelInventory.computeIfAbsent(channelId, k -> new HashMap<>()).put(bond, quantity);
    }

    // 获取债券可售额度
    public int getInventory(String channelId, String bond) {
        return channelInventory.getOrDefault(channelId, new HashMap<>()).getOrDefault(bond, -1);
    }

    // 增加债券可售额度
    public void increaseInventory(ChangeQuotationDto dto) {
        String channelId = dto.getChannelId();
        String bond = dto.getBondCode();
        int quantity = dto.getChangeQuantity();
        int currentQuantity = getInventory(channelId, bond);
        channelInventory.computeIfAbsent(channelId, k -> new HashMap<>()).put(bond, currentQuantity + quantity);
        logger.info(String.format("increase %1s %2s into %3s \n", quantity,bond, Channel.getDisplayName(channelId)));
    }

    // 减少债券可售额度
    public void decreaseInventory(ChangeQuotationDto dto) {
        String channelId = dto.getChannelId();
        String bond = dto.getBondCode();
        int quantity = Math.abs(dto.getChangeQuantity());
        int currentQuantity = getInventory(channelId, bond);
        if (currentQuantity >= quantity) {
            channelInventory.get(channelId).put(bond, currentQuantity - quantity);
            logger.info(String.format("decrease %1s %2s from %3s \n", quantity,bond, Channel.getDisplayName(channelId)));
        } else {
            logger.info(String.format("insufficient amount of %1s  from %2s \n", bond, Channel.getDisplayName(channelId)));
        }
    }

    public boolean isNewBondInChannel(String bondCode, String channelId){
        return getInventory(channelId, bondCode) >= 0 ? true : false;
    }
}
