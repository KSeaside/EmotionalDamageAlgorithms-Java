package com.kseaside.designpatterns.thechainofresponsibilitypattern;

// 组装手臂的工人，进行手臂组装，此处重写了doWork方法，可以对链路进行控制，想终止可以终止链路继续执行
//（如觉得身体组装的不行，我手臂没地方插，没法完成工作，则不执行手臂安装，后续链路也更不用执行了）
public class ArmWorker extends ToyPipeline{
    @Override
    protected void doRealWork() {
        System.out.println("我是手臂组装流水工，我组装了手臂");
    }

    @Override
    public void doWork() {
        // 重写父类的doWork方法
        // 如果身体组装的有问题则不进行组装，也不进行下面的工作
//		if(body != 完美) {
//		   System.out.println("身体组装不完美，返工");
//			return;
//		}
        doRealWork();
        if(next != null) {
            next.doWork();
        }
    }
}
