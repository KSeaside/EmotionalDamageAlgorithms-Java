package com.kseaside.weeklycontest.w298;

import java.util.HashMap;

//给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。
// 返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
//
// 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
//
// 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
public class Test5242 {

    public String greatestLetter(String s) {

        int len = s.length();
        String better = "";
        int b = 0;
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len; j++) {

                if (Math.abs(s.charAt(i) - s.charAt(j)) == 32) {
                    int a = Math.min(s.charAt(i), s.charAt(j));
                    b = Math.max(a, b);
                    better = String.valueOf((char)b);
                }
            }
        }

        return better;
    }

    public static void main(String[] args) {
        System.out.println((char)('A' + 32));
        System.out.println('a' +1); //98
        System.out.println('A' + 1); //66
    }
}
