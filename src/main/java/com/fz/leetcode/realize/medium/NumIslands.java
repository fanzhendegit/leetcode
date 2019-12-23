package com.fz.leetcode.realize.medium;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 18:02
 * @Version 2.0.0
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 岛屿数量
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        if(grid.length==0) {
            return 0;
        }
        if(grid[0].length==0) {
            return 0;
        }

        int width=grid.length;
        int length=grid[0].length;
        int count=0;
        for (int i=0;i<width;i++){
            for (int j=0;j<length;j++){
                if(grid[i][j]=='1') {
                    count++;
                    search(i,j,grid,width,length);
                }
            }
        }
        return count;
    }

    private void search(int i,int j,char[][] grid,int width,int length){
        if(i<0||i==width||j<0||j==length){
            return;
        }
        /**
         *  进行染色，能探测到的1都是一个岛屿的直接上色
         */
        if(grid[i][j]=='1') {
            grid[i][j]='0';
            search(i,j+1,grid,width,length);
            search(i+1,j,grid,width,length);
            search(i-1,j,grid,width,length);
            search(i,j-1,grid,width,length);
        }

    }
}
