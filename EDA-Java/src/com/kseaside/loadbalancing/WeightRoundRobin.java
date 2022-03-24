package com.kseaside.loadbalancing;

//轮询优化
public class WeightRoundRobin {
    public static String getServer(Integer num) {
        // 计算总权重
        int totalWeights = ServerIps.WEIGHT_LIST.values().stream().mapToInt(w -> w).sum();

        Integer pos = num % totalWeights;

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
            System.out.println(getServer(i));
        }
    }
}
