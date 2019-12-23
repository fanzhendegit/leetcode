package com.fz.leetcode.realize.primary;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 15:28
 * @Version 2.0.0
 *
 * 买入卖出最大利润
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int min=prices[0];
        int max=0;
        for (int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            max=Math.max(prices[i]-min,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
