package com.fz.leetcode.realize.exclusive;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 15:29
 * @Version 2.0.0
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result=0;
        int[] temp=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        int end=temp.length/2;
        while (k<=end&&i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                temp[k]=nums1[i];
                i++;
            }else {
                temp[k]=nums2[j];
                j++;
            }
            k++;
        }
        while (k<=end&&i<nums1.length){
            temp[k]=nums1[i];
            i++;
            k++;
        }
        while (k<=end&&j<nums2.length){
            temp[k]=nums2[j];
            j++;
            k++;
        }
        if(temp.length%2==0){
            result=(temp[temp.length/2]+temp[temp.length/2-1])/2.0d;
        }else {
            result=temp[temp.length/2];
        }
        return result;
    }
}
