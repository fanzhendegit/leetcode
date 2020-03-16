package com.fz.leetcode.realize.medium;

/**
 * @author fanzhen
 * @date 2020/2/6--16:39
 *
 * 旋转图像
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                /*
                    n-1内层循环
                 */
                matrix[i][j] = matrix[n - 1 - j][i];
                           matrix[n - 1 - j][i] = matrix[n-1-i][n - 1 - j];
                                      matrix[n-1-i][n - 1 - j] = matrix[j][n-1-i];
                                         matrix[j][n-1-i] = temp;
            }
        }
    }
}
