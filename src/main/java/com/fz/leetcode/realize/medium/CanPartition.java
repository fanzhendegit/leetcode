package com.fz.leetcode.realize.medium;

/**
 * @author fanzhen
 * @date 2020/2/7--11:43
 *
 * 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        //转化为经典的01背包问题
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        /*
            如果和不能被2整除，那么必然不能被等分
         */
        if (sum % 2 == 1) {
            return false;
        }

        /*
            目标值
         */
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        //建立dp数组，dp[i]表示能否找到和为i的数组元素集合
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num])
                {
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}
