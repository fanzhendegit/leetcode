package com.fz.leetcode.realize.medium;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 18:09
 * @Version 2.0.0
 *
 * 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int row=matrix.length,col=row==0?0:matrix[0].length;
        int[][] dp=new int[row+1][col+1];
        int max=0;
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1])+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
