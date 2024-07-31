package com.kseaside.hot100;

/**
 * @Description: https://leetcode.cn/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
 * @author: kray
 * @date: 2024/7/31 14:44
 **/
public class LC58 {
    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        return array[array.length - 1].length();
    }
}
