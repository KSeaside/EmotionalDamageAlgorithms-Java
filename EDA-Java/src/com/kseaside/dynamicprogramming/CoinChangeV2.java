package com.kseaside.dynamicprogramming;

/**
 *  这道题在一次面试字节的时候遇到过，当时隐约记得做过，脑子一闪而过动态规划，可怎么也想不起来怎么做，记录一下~
 *
 *给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 */
public class CoinChangeV2 {
    /**
     * 初始化 dp[0]=1；
     *
     * 遍历 coins，对于其中的每个元素coin，进行如下操作：
     *
     * 遍历 ii 从coin 到 amount，将 dp[i−coin] 的值加到 dp[i]。
     * 最终得到 \dp[amount] 的值即为答案。
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
