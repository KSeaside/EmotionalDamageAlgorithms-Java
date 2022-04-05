package com.kseaside.JavaTest;

import java.util.function.Consumer;

/**
 * 接收一个参数 没有返回结果
 */
public class ConsumerDemo {
    public static void modifyTheValue3(int value, Consumer<Integer> consumer) {
        consumer.accept(value);
    }

    public static void main(String[] args) {
        // (x) -> System.out.println(x * 2)接受一个输入参数x
        // 直接输出，并没有返回结果
        // 所以该lambda表达式可以实现Consumer接口
        modifyTheValue3(3, (x) -> System.out.println(x * 2));
    }

}
