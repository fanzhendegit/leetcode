package com.fz.leetcode.realize.medium;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 19:11
 * @Version 2.0.0
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean flag=true;
        int i=0,j=0;
        int length=matrix.length;
        int width=length==0?0:matrix[0].length;


        while (i>=0&&j>=0&&i<length&&j<width){
            int temp=matrix[i][j];
            if(temp==target) {
                return true;
            }
            else if(temp>target){
                /*
                    判断是否翻墙
                 */
                if(flag){
                    /*
                        若未翻墙进入下行前一个点
                     */
                    i++;
                    j--;
                    flag=false;
                }else {
                    /*
                        未翻墙可以向前探索
                     */
                    j--;
                }
            }else{
                if(j+1==width){
                    /*
                        到达边界翻墙
                     */
                    i++;
                    flag=false;
                }else {
                    /*
                        向后搜索
                     */
                    j++;
                    flag=true;
                }
            }
        }
        return false;
    }
}
