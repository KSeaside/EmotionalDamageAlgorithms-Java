package com.kseaside.JavaTest;

import java.util.function.Predicate;

/**
 * 接受一个输入参数，返回一个布尔值结果
 */
public class PredicateDemo {
    public static boolean predicateTest(int value, Predicate<Integer> predicate) {
        return predicate.test(value);
    }

    public static void main(String[] args) {
        // (x) -> x == 3 输入一个参数x，进行比较操作，返回一个布尔值
        // 所以该lambda表达式可以实现Predicate接口
        System.out.println(predicateTest(3, (x) -> x == 3));
    }

}
