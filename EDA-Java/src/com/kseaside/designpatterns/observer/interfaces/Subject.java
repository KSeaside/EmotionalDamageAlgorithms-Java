package com.kseaside.designpatterns.observer.interfaces;

public interface Subject {
    //被观察者的接口：注册、取消注册、观察通知
    void reg(Observer obs);
    void unreg(Observer obs);
    void sendMessage(String msg);
}
