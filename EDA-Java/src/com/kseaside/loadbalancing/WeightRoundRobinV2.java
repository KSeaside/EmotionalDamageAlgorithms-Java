package com.kseaside.loadbalancing;

import java.util.HashMap;
import java.util.Map;

public class WeightRoundRobinV2 {

    public static Map<String,Weight> currWeights = new HashMap<>();

    public static String getServer() {
        // 计算总权重
        int totalWeights = ServerIps.WEIGHT_LIST.values().stream().mapToInt(w -> w).sum();

        //currentWeight 默认值 0
        if(currWeights.isEmpty()) {
            ServerIps.WEIGHT_LIST.forEach((ip,weight)->
            {
                currWeights.put(ip,new Weight(ip,weight,0));
            });
        }

        for(Weight weight: currWeights.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }

        //找最大值
        Weight maxCurrentWeight = null;
        for(Weight weight: currWeights.values()) {
            if(maxCurrentWeight == null || weight.getCurrentWeight() > maxCurrentWeight.getCurrentWeight()) {
                maxCurrentWeight = weight;
            }
        }

        maxCurrentWeight.setCurrentWeight( maxCurrentWeight.getCurrentWeight() - totalWeights);

        return maxCurrentWeight.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
