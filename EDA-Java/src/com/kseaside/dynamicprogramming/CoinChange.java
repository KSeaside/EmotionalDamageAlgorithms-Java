package com.kseaside.dynamicprogramming;

import java.util.Arrays;

/**
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {
    /**
     *
     * F(i)	最小硬币数量
     * F(0)	0 //金额为0不能由硬币组成
     * F(1)	1 F(1)=min(F(1−1),F(1−2),F(1−5))+1=1
     * F(2)	1 F(2)=min(F(2−1),F(2−2),F(2−5))+1=1
     * F(3)	2 F(3)=min(F(3−1),F(3−2),F(3−5))+1=2
     * F(4)	2 F(4)=min(F(4−1),F(4−2),F(4−5))+1=2
     * ...	...
     * F(11)	3 F(11)=min(F(11−1),F(11−2),F(11−5))+1=3
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
