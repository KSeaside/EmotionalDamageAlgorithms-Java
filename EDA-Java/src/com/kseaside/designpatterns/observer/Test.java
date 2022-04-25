package com.kseaside.designpatterns.observer;

import com.kseaside.designpatterns.observer.impl.Building;
import com.kseaside.designpatterns.observer.impl.Yourself;
import com.kseaside.designpatterns.observer.interfaces.Observer;
import com.kseaside.designpatterns.observer.interfaces.Subject;

public class Test {
    public static void main(String[] args) {
        //创建一个售楼处的小姐姐(生产者)
        Subject sister = new Building();
        //创建3个观察者(消费者)
        Observer ys1 = new Yourself("张三");
        Observer ys2 = new Yourself("李四");
        Observer ys3 = new Yourself("王五");

        //去售楼处加小姐姐的微信
        sister.reg(ys1);
        sister.reg(ys2);
        sister.reg(ys3);

        //某天李四通知小姐姐取消订阅，说我不看了别发我了
        sister.unreg(ys2);

        //楼盘价格降了，售楼处的小姐姐通过加的微信通知观察者
        sister.sendMessage("楼房价格降低了");

    }

}
