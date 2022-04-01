package com.kseaside.designpatterns.thechainofresponsibilitypattern;

public class MyChain {

    public static void main(String[] args) {
        final BodyWorker bodyWorker = new BodyWorker();
        final ArmWorker armWorker = new ArmWorker();
        final ColorWorker colorWorker = new ColorWorker();

        bodyWorker.setNextPipeline(armWorker);
        armWorker.setNextPipeline(colorWorker);

        bodyWorker.doWork();
    }
}
