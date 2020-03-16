package com.fz.leetcode.realize.medium;

/**
 * @Author: fanzhen
 * @Date: 2019/12/18 11:42
 * @Version 2.0.0
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePaths {

    private int uniquePaths(int m, int n) {
        if(m>n){
            int tem=m;
            m=n;
            n=tem;
        }
        /*
            防止溢出
         */
        long result=1;
        for (int i=m+n-2;i>n-1;i--){
            result=result*i;
        }
        int temp=1;
        for (int j=1;j<m;j++){
            temp=temp*j;
        }
        result=result/temp;
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(10,10));
        System.out.println(new UniquePaths().uniquePaths(1,3));
        System.out.println(String.format("Cannot get agvType:%s from evo-rcs-basic!","Me"));
    }
}
