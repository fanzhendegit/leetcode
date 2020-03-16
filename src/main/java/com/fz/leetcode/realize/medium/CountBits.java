package com.fz.leetcode.realize.medium;

/**
 * @author fanzhen
 * @date 2020/2/7--0:00
 */
public class CountBits {

    /*
        汉明计数
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;

            /*
                位运算，n和n-1刚好抹除一位1
             */
            n &= (n - 1);
        }
        return sum;
    }

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++i)
        {
            ans[i] = hammingWeight(i);
        }
        return ans;
    }

}
