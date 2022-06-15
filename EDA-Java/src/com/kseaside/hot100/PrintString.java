package com.kseaside.hot100;

// 两个线程交替打印大写字母和小写紫米
public class PrintString {
    // 线程安全
    static StringBuffer s = new StringBuffer();
    static int count = 0;
    static int countA = 0;
    static int countB = 0;
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        ThreadA a = new ThreadA(object);
        ThreadB b = new ThreadB(object);
        a.start();
        b.start();
        Thread.sleep(10000);
        System.out.println("Print String is " + s);
        System.out.println("Thread A millisecond is " + a.getTime());
        System.out.println("Thread B millisecond time is " + b.getTime());

    }


    static class ThreadA extends Thread {
        private Object object;
        private long time;

        public ThreadA(Object o) {
            this.object = o;

        }

        public long getTime() {
            return time;
        }

        public void run() {
            while (count < 52) {
                synchronized (object) {
                    long start = System.currentTimeMillis();
                    s.append((char) ('a' + countA));
                    System.out.print((char) ('a' + countA));
                    count++;
                    countA++;
                    long end = System.currentTimeMillis();
                    time += end - start;
                    if (count % 2 == 1) {
                        object.notifyAll();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    static class ThreadB extends Thread {
        private Object object;
        private long time;

        public ThreadB(Object o) {
            this.object = o;
        }
        public long getTime() {
            return time;
        }
        public void run() {
            while (count < 52) {
                synchronized (object) {
                    long start = System.currentTimeMillis();
                    s.append((char) ('A' + countB));
                    System.out.print((char) ('A' + countB));
                    count++;
                    countB++;
                    long end = System.currentTimeMillis();
                    time += end - start;
                    if (count % 2 == 0) {
                        object.notifyAll();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }

    }
}
