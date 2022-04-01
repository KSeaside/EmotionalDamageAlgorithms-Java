package com.kseaside.designpatterns.thechainofresponsibilitypattern;

// 身体组装流水工，进行身体组装
public class BodyWorker extends ToyPipeline{

    @Override
    protected void doRealWork() {
        System.out.println("我是身体组装流水工，我组装了身体");
    }
}
