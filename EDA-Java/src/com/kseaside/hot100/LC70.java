package com.kseaside.hot100;

/**
 * @Description: 70
 * @author: kray
 * @date: 2024/8/8 17:59
 **/
public class LC70 {
        public int climbStairs(int n) {
            int a = 1, b = 1, sum;
            for(int i = 0; i < n - 1; i++){
                sum = a + b;
                a = b;
                b = sum;
            }
            return b;
        }
}
