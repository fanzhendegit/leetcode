package com.fz.leetcode.realize.medium;

/**
 * @author fanzhen
 * @date 2020/2/6--23:06
 *
 * 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, lmax = 1, lmin = 1;

        /*
            动态规划，记录最大值和最小值，因为负负为正，所以最小值也可能乘下一个数字后变为最大值
         */
        for(int i=0; i<nums.length; i++){
            lmax=lmax*nums[i];
            lmin=lmin*nums[i];
            if(lmax<lmin){
                int temp=lmax;
                lmax=lmin;
                lmin=temp;
            }
            lmax=Math.max(lmax,nums[i]);
            lmin=Math.min(lmin,nums[i]);

            max = Math.max(max, lmax);
        }
        return max;
    }
}
