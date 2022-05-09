package com.kseaside.designpatterns.singleton;

public class SingletonDoubleDetection {
    private volatile static SingletonDoubleDetection instance = null;

    private SingletonDoubleDetection() {}

    public static SingletonDoubleDetection getInstance() {
        if (instance == null) {
            synchronized(SingletonDoubleDetection.class) { // 此处为类级别的锁
                if (instance == null) {
                    instance = new SingletonDoubleDetection();
                }
            }
        }
        return instance;
    }


}
