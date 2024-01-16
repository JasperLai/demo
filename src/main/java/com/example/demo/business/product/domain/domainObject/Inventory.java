package com.example.demo.business.product.domain.domainObject;

import java.util.Map;

import java.util.HashMap;

public class Inventory {
    private Map<String, Map<String, Integer>> channelInventory; // 渠道和债券的可售额度

    public Inventory() {
        this.channelInventory = new HashMap<>();
    }

    // 初始化债券可售额度
    public void initializeInventory(String channel, String bond, int quantity) {
        channelInventory.computeIfAbsent(channel, k -> new HashMap<>()).put(bond, quantity);
    }

    // 获取债券可售额度
    public int getInventory(String channel, String bond) {
        return channelInventory.getOrDefault(channel, new HashMap<>()).getOrDefault(bond, 0);
    }

    // 增加债券可售额度
    public void increaseInventory(String channel, String bond, int quantity) {
        int currentQuantity = getInventory(channel, bond);
        channelInventory.computeIfAbsent(channel, k -> new HashMap<>()).put(bond, currentQuantity + quantity);
        System.out.println("增加了 " + quantity + bond + " 到渠道 " + channel + " 的可售额度。");
    }

    // 减少债券可售额度
    public void decreaseInventory(String channel, String bond, int quantity) {
        int currentQuantity = getInventory(channel, bond);
        if (currentQuantity >= quantity) {
            channelInventory.get(channel).put(bond, currentQuantity - quantity);
            System.out.println("减少了 " + quantity + bond + " 从渠道 " + channel + " 的可售额度。");
        } else {
            System.out.println("渠道 " + channel + " 的 " + bond + " 可售额度不足 " + quantity + " 枚。");
        }
    }

    public static void main(String[] args) {
        // 示例用法
        Inventory inventory = new Inventory();

        // 初始化债券可售额度
        inventory.initializeInventory("渠道A", "债券X", 100);
        inventory.initializeInventory("渠道B", "债券Y", 50);

        // 获取债券可售额度
        System.out.println("渠道A 的债券X 可售额度: " + inventory.getInventory("渠道A", "债券X"));

        // 增加债券可售额度
        inventory.increaseInventory("渠道A", "债券X", 20);

        // 减少债券可售额度
        inventory.decreaseInventory("渠道B", "债券Y", 30);
    }
}
