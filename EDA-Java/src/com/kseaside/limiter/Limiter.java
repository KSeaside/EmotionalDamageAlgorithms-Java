package com.kseaside.limiter;

// 网站或者API服务有可能被恶意访问导致不可用，为了防止被DOS攻击，通常会进行访问频率限制。
// 请求包含 clientId 信息，请实现一个 RateLimiter 类，包含 isAllow(String clientId) 方法。
// 如果某个 client 在 1 秒钟内有超过 100 次请求，就拒绝响应。
// 语言不限，如果用 Java，你可能需要实现以下接口

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;


public class Limiter {

    // 考虑线程安全使用concurrentHashMap
    ConcurrentHashMap<String, Client> map = new ConcurrentHashMap<String, Client>();

    boolean isAllow(String clientId) {
        // 获取当前时间
        long currentTime = System.nanoTime();
        // 如果map 中不存在当前clientId
        if (map.get(clientId) == null) {
            map.put(clientId, new Client(clientId, currentTime, 1000 * 1000, 100));
            return true;
        } else {
            // 如果map 中存在当前clientId
            Client client = map.get(clientId);
            return client.isAllowable();
        }
    }

    class Client {
        private String clientId; //当前clientId
        private long requestTime; // 访问时间 纳米级时间戳
        private int count; // 最高访问次数限制 100
        private long interval; // 访问时间间隔 1s
        private LongAdder token; // 这里可以使用AtomicLong  高并发场景下LongAdder性能更好

        public Client(String clientId, long requestTime, long interval, int count) {
            this.clientId = clientId;
            this.requestTime = requestTime;
            this.interval = interval;
            this.token = buildLongAdder(count);
        }

        //是否允许访问，true 为允许
        public boolean isAllowable() {
            long now = System.nanoTime(); // 记录当前时间毫秒
            // 判断当前时间是否大于上次访问时间+时间间隔 即是否在1s内
            if (now > requestTime + interval) {
                // 使用LongAdder递减判断当前访问是否超过100次的限制
                token = buildLongAdder(count);
                requestTime = now;
            }
            // 获取当前剩余访问次数并判断是否小于0
            if (token.sum() < 0) {
                return false;
            }
            // 访问次数-1
            token.decrement();
            return true;
        }

        public long getInterval() {
            return interval;
        }

        public int getCount() {
            return count;
        }

        long getRequestTime() {
            return requestTime;
        }

        long getToken() {
            return token.sum();
        }

        // 使用LongoingAdder 高并发场景有更高的吞吐量
        // AtomicLong 精度更高但是高并发场景需要更高的空间消耗
        private LongAdder buildLongAdder(int count) {
            LongAdder adder = new LongAdder();
            adder.add(count);
            return adder;
        }


    }

}
