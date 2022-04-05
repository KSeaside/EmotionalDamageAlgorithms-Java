package com.kseaside.JavaTest;

import java.util.function.Supplier;

/**
 * 无参数，返回一个结果
 */
public class SupplierDemo {

    public static String supplierTest(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String args[]) {
        String name = "冷冷";
        // () -> name.length() 无参数，返回一个结果（字符串长度）
        // 所以该lambda表达式可以实现Supplier接口
        System.out.println(supplierTest(() -> name.length() + ""));
    }
}
