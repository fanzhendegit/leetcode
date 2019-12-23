package com.fz.leetcode.realize.medium;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 10:52
 * @Version 2.0.0
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class NumTrees {


    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        /*
            依次叠加，左右互分
         */
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(5));
    }
}
