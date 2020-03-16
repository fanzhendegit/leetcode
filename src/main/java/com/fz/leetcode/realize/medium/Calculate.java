package com.fz.leetcode.realize.medium;

/**
 * @author fanzhen
 * @date 2020/2/7--11:49
 *
 * 给定数组，每个数字前可以放置加号或者减号。计算结果等于S的放置方式有几种
 */
public class Calculate {

    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length&&sum==S) {
            count++;
        } else if(i<nums.length){
            /*
                下一个不是加就是减
             */
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }


}
