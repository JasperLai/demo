package com.example.demo.business.product.domain.domainObject;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.demo.business.product.app.request.ChangeQuoteDto;
import com.example.demo.business.product.domain.valueObject.Channel;

import java.util.HashMap;

public class Inventory {

    //默认渠道
    private static String DEFAULT_CHANNEL = "1001";

    private static final Logger logger = LogManager.getLogger(Inventory.class);

    private Map<String, Map<String, Integer>> channelInventory; // map<channelid， map<bondCode, quantity>>


    public void setChannelInventory(Map<String,Map<String,Integer>> channelInventory) {
        this.channelInventory = channelInventory;
    }

    public Inventory() {
        this.channelInventory = new HashMap<>();
    }

    // 初始化债券可售额度
    public void initializeInventory(ChangeQuoteDto dto) {
        String channelId = dto.getChannelId();
        String bond = dto.getBondCode();
        int quantity = dto.getChangeQuantity();
        channelInventory.computeIfAbsent(channelId, k -> new HashMap<>()).put(bond, quantity);
    }

    public void initializeInventory(String bondCode, int defaultValue) {
        // 检查是否已存在 bondCode 的记录，不存在则创建
        channelInventory.computeIfAbsent(DEFAULT_CHANNEL, k -> new HashMap<>());
        
        // 设置默认总行渠道的额度
        channelInventory.get(DEFAULT_CHANNEL).put(bondCode, defaultValue);
        
        logger.info("Initialized inventory for bondCode {}", bondCode);
    }

    // 获取债券可售额度
    public int getInventory(String channelId, String bond) {
        return channelInventory.getOrDefault(channelId, new HashMap<>()).getOrDefault(bond, -1);
    }

    // 增加债券可售额度
    public void increaseInventory(ChangeQuoteDto dto) throws Exception{
        String channelId = dto.getChannelId();
        String bond = dto.getBondCode();
        int quantity = dto.getChangeQuantity();
        int currentQuantity = getInventory(channelId, bond);
        //TODO 此处需要增加库存增加上限机制， 即库存高于于某个设定的值以后，抛出自定义库存过剩异常交易失败
        channelInventory.computeIfAbsent(channelId, k -> new HashMap<>()).put(bond, currentQuantity + quantity);
        logger.info(String.format("increase %1s %2s into %3s \n", quantity,bond, Channel.getDisplayName(channelId)));
    }

    // 减少债券可售额度
    public void decreaseInventory(ChangeQuoteDto dto) throws Exception{
        String channelId = dto.getChannelId();
        String bond = dto.getBondCode();
        int quantity = Math.abs(dto.getChangeQuantity());
        int currentQuantity = getInventory(channelId, bond);
        //TODO 此处需要增加库存下限机制， 即库存低于某个设定的值以后，抛出自定义库存不足异常
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
    public static class InventoryBuilder {
        private final Inventory inventory;

        public InventoryBuilder() {
            this.inventory = new Inventory();
        }

        public InventoryBuilder withChannelInventory(Map<String, Map<String, Integer>> channelInventory) {
            inventory.setChannelInventory(channelInventory);
            return this;
        }

        public InventoryBuilder initializeInventory(String bondCode, int defaultValue) {
            inventory.initializeInventory(bondCode,defaultValue);
            return this;
        }

        public Inventory build() {
            return inventory;
        }
    }
}
