package com.fz.leetcode.realize.medium;

import java.util.Arrays;

/**
 * @Author: fanzhen
 * @Date: 2019/12/18 15:33
 * @Version 2.0.0
 *
 * 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColors {

    public void sortColors(int[] nums) {

        /*
            双指针
         */
        int one=0,two=nums.length-1;
        int zero=0;
        while (one<=two){
            if(nums[one]==0){
                swap(zero++,one++,nums);
            }else if(nums[one]==2){
                while (two>one&&nums[two]==2){
                    two--;
                }
                swap(one,two--,nums);
            }else {
                one++;
            }
        }
    }

    private void swap(int i,int j,int[] nums){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }

    public static void main(String[] args){
        int[] nums=new int[]{1,2,0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
