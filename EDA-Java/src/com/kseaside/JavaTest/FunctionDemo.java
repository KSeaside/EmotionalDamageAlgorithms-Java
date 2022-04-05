package com.kseaside.JavaTest;

import java.util.function.Function;

/**
 * 接收一个输入参数，返回一个结果
 */
public class FunctionDemo {

    static int modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function) {
        return function.apply(valueToBeOperated);
    }

    public static void main(String[] args) {
        int myNumber = 10;

        // 使用lambda表达式实现函数式接口
        // (x)->(x)+20 输入一个参数x，进行加法运算，返回一个结果
        // 所以该lambda表达式可以实现Function接口
        int res1 = modifyTheValue(myNumber, (x)-> x + 20);
        System.out.println(res1); // 30

        //  使用匿名内部类实现
        int res2 = modifyTheValue(myNumber, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t + 20;
            }
        });
        System.out.println(res2); // 30
    }

    public static Integer modifyTheValue2(int value, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        //value作为function1的参数，返回一个结果，该结果作为function2的参数，返回一个最终结果
        return  function1.andThen(function2).apply(value);
    }

    public static void main1(String[] args) {
        System.out.println(modifyTheValue2(3, val -> val + 2, val -> val + 3));
    }
}
