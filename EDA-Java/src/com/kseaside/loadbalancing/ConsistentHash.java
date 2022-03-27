package com.kseaside.loadbalancing;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性hash
 */
public class ConsistentHash {
    private static TreeMap<Integer,String> virtualNodes = new TreeMap();
    private static final int VIRTUAL_NODES = 160;//虚拟节点个数

    //预处理 哈希环
    static {
        //对每个真实节点添加虚拟节点 根据hash算法进行散列
        for(String ip: ServerIps.LIST) {
            for(int i = 0; i < VIRTUAL_NODES; i++) {
                int hash = getHash(ip+"VN"+i);
                virtualNodes.put(hash,ip);
            }
        }
    }

    /**
     * 获取服务ip
     * @param clientInfo 客户端信息
     * @return 服务ip
     */
    public static String getServer(String clientInfo) {
        int hash = getHash(clientInfo);
        //得到大于该Hash值的子红黑树
        SortedMap<Integer,String> subMap = virtualNodes.tailMap(hash);
        //获取该子树最小元素
        Integer nodeIndex = subMap.firstKey();

        //没有大于该元素的子树 取整树的第一个元素
        if (nodeIndex == null) {
            nodeIndex = virtualNodes.firstKey();
        }
        return virtualNodes.get(nodeIndex);
    }


    /**
     * hash算法
     */
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash^str.charAt(i))*p;
            hash +=hash <<13;
            hash ^=hash >>7;
            hash +=hash <<3;
            hash ^=hash >>17;
            hash +=hash <<5;
            //如果算出来的值为负数 取其绝对值
            if(hash < 0) {
                hash = Math.abs(hash);
            }
        }
        return hash;
    }
}
