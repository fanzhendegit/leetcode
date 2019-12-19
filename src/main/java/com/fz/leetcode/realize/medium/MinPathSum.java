package com.fz.leetcode.realize.medium;

/**
 * @Author: fanzhen
 * @Date: 2019/12/18 11:59
 * @Version 2.0.0
 *
 * 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=row==0?0:grid[0].length;
        if(row==0||col==0){
            return 0;
        }
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                int max=Integer.MAX_VALUE;
                if(i!=0){
                    max=grid[i-1][j];
                }
                if(j!=0){
                    max=max>grid[i][j-1]?grid[i][j-1]:max;
                }
                if(i==0&&j==0){
                    max=0;
                }
                grid[i][j]=grid[i][j]+max;
            }
        }
        return grid[row-1][col-1];
    }
    
    public static void main(String[] args){
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    
}
