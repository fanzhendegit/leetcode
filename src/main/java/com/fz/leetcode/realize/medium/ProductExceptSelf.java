package com.fz.leetcode.realize.medium;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 19:10
 * @Version 2.0.0
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int tempL=1;
        int tempR=1;
        int[] tempNumsL=new int[nums.length];
        int[] tempNumsR=new int[nums.length];
        int[] result=new int[nums.length];
        /*
            左右计算并放于记录
         */
        for (int i=0;i<nums.length;i++){
            tempNumsL[i]=tempL*nums[i];
            tempL=tempNumsL[i];
            tempNumsR[nums.length-i-1]=tempR*nums[nums.length-i-1];
            tempR=tempNumsR[nums.length-i-1];
        }
        result[0]=tempNumsR[1];
        result[nums.length-1]=tempNumsL[nums.length-2];

        /*
            左乘和右乘
         */
        for (int i=1;i<nums.length-1;i++){
            result[i]=tempNumsL[i-1]*tempNumsR[i+1];
        }
        return result;
    }
}
