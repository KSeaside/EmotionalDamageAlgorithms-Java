package com.kseaside.designpatterns.singleton;

public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy() {
    }

    public synchronized SingletonLazy getInstance() {
        if (null == instance) {
            instance = new SingletonLazy();
        }
        return instance;
    }


}
