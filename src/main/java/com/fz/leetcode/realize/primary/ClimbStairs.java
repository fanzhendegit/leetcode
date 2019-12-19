package com.fz.leetcode.realize.primary;

/**
 * @Author: fanzhen
 * @Date: 2019/12/18 15:29
 * @Version 2.0.0
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        int[] result=new int[n+1];
        result[0]=0;
        result[1]=1;
        result[2]=2;

        /*
           动态规划方程：dp[i]=dp[i-1]+dp[i-1]
         */
        for (int j=3;j<=n;j++){
            result[j]=result[j-1]+result[j-2];
        }
        return result[n];
    }
}
