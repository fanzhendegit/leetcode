package com.fz.leetcode.realize.primary;

import com.fz.leetcode.realize.medium.Permute;

/**
 * @Author: fanzhen
 * @Date: 2019/12/18 10:45
 * @Version 2.0.0
 *
 *
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int max=nums[0];
        int sum=0;
        for (int num : nums) {
            /*
                如果前面的和为负数，舍弃前面的值，从当前位置开始
             */
            int temp = sum + num;
            sum = temp > num ? temp : num;
            max = sum > max ? sum : max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
