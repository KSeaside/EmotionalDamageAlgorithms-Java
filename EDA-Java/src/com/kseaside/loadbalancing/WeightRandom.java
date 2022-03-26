package com.kseaside.loadbalancing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  带权重随机
 *
 *  缺点 权重大 ips越大 占内存
 */

public class WeightRandom {
    public static String getServer() {
        //生成随机数作为List下标
        List<String> ips = new ArrayList<>();

        for (String ip: ServerIps.WEIGHT_LIST.keySet()) {
            Integer weight = ServerIps.WEIGHT_LIST.get(ip);
            //weight多少 在ips里面存多少 例 A 权重为2 在ips里面存两个
            for (int i = 0; i < weight ; i++) {
                ips.add(ip);
            }
        }
        Random random = new Random();
        int randomPos = random.nextInt(ips.size());
        return ips.get(randomPos);
    }
}
