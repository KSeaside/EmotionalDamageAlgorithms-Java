package com.kseaside.hot100;

/**
 * @Description: https://leetcode.cn/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
 * @author: kray
 * @date: 2024/7/30 11:25
 **/
public class LC134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

}
