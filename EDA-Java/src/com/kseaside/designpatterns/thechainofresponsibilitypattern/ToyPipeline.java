package com.kseaside.designpatterns.thechainofresponsibilitypattern;

// 定义抽象类
// 有setNextPipeline方法，设置链路中下一个处理者是谁
// doWork，来调用当前处理者工作，处理完成后调用下一个处理者，如果下一个处理者不存在则执行结束
public abstract class ToyPipeline {
    ToyPipeline next;

    public void setNextPipeline(ToyPipeline toyPipeline) {
        this.next = toyPipeline;
    }

    public void doWork() {
        doRealWork();
        if(next != null) {
            next.doWork();
        }
    }

    protected abstract void doRealWork();
}
