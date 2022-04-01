package com.kseaside.designpatterns.thechainofresponsibilitypattern;

// 上颜色
public class ColorWorker extends ToyPipeline{
    @Override
    protected void doRealWork() {
        System.out.println("我是上色流水工，你们组装完我给玩具上色");
    }
}
