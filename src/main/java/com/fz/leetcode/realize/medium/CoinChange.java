package com.fz.leetcode.realize.medium;

import java.util.Arrays;

/**
 * @author fanzhen
 * @date 2020/2/6--23:35
 *
 * 硬币置换
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {

                    /*
                        动态规划方程，挨个计算
                     */
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
