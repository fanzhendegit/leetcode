package com.fz.leetcode.realize.medium;

/**
 * @Author: fanzhen
 * @Date: 2019/12/17 15:01
 * @Version 2.0.0
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        /*
            从后向前找到第一个逆序位置
         */
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        /*
            将第一个大于nums[i]的数字进行交换，此位置j后面的数字都比位置i的数字小
         */
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        /*
            第一个while决定了后面都是降序的，此时得到升序列表只需反转列表即可
         */
        reverse(nums, i + 1);
    }

    /**
     * 列表反转
     * @param nums
     * @param start
     */
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
