package com.fz.leetcode.realize.primary;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 16:06
 * @Version 2.0.0
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int num=nums[0];
        for (int i=1;i<nums.length;i++){

            /*
                 两两异或
             */
            num=num^nums[i];
        }
        return num;
    }
}
