package com.kseaside.loadbalancing;

import java.util.Random;

/**
 * 带权重随机
 */
public class WeightRandomV2 {
    public static String getServer() {
        //总权重
        int totalWeights = ServerIps.WEIGHT_LIST.values().stream().mapToInt(w -> w).sum();

        Random random = new Random();
        int pos = random.nextInt(totalWeights);

        for(String ip: ServerIps.WEIGHT_LIST.keySet()) {
            Integer weight = ServerIps.WEIGHT_LIST.get(ip);
            if(pos < weight) {
                return ip;
            }
            pos = pos - weight;
        }

        return "";
    }

    public static void main(String[] args) {
        for (int i=0 ; i<10 ; i++) {
            System.out.println(getServer());
        }
    }
}
