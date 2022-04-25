package com.kseaside.designpatterns.observer.impl;

import com.kseaside.designpatterns.observer.interfaces.Observer;
import com.kseaside.designpatterns.observer.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class Building implements Subject {
    List<Observer> obses = new ArrayList<Observer>();
    //注册
    @Override
    public void reg(Observer obs) {
        obses.add(obs);
    }
    //取消注册 拉黑
    @Override
    public void unreg(Observer obs) {
        if (!obses.isEmpty()&&obses.contains(obs)){
            obses.remove(obs);
        }
    }
    //发消息，群发
    @Override
    public void sendMessage(String msg) {
        for (Observer obs : obses) {
            obs.update("某个售楼处的小姐姐："+msg);
        }
    }

}
