package com.fz.leetcode.realize.medium;

import java.util.Arrays;

/**
 * @Author: fanzhen
 * @Date: 2019/12/17 17:48
 * @Version 2.0.0
 *
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int i=0,j=nums.length-1;
        int[] pos=new int[]{nums.length,-1};
        int temp=-1;
        while (j-i>1){
            if(nums[i]==target){
                pos[0]=i<pos[0]?i:pos[0];
            }
            if(nums[j]==target){
                pos[1]=j>pos[1]?j:pos[1];
            }

            if(pos[0]<nums.length&&pos[1]>0){
                break;
            } else {
                temp=(i+j)/2;
                if(nums[temp]>target){
                    j=temp;
                }else if(nums[temp]<target){
                    i=temp;
                }else {
                    searchLeft(i,temp,target,nums,pos);
                    searchRight(temp,j,target,nums,pos);
                    break;
                }
            }
        }
        if(nums[i]==target){
            pos[0]=i<pos[0]?i:pos[0];
            pos[1]=i>pos[1]?i:pos[1];
        }
        if(nums[j]==target){
            pos[0]=j<pos[0]?j:pos[0];
            pos[1]=j>pos[1]?j:pos[1];
        }
        if(pos[0]==nums.length){
            pos[0]=-1;
        }
        return pos;
    }

    private void searchLeft(int start,int end,int target,int[] nums,int[] pos){
        while (end-start>1){
            if(nums[start]==target){
                pos[0]=start<pos[0]?start:pos[0];
                break;
            }else {
                int temp=(start+end)/2;
                if(nums[temp]<target){
                    start=temp;
                }else {
                    end=temp;
                }
            }
        }
        if(nums[end]==target){
            pos[0]=end<pos[0]?end:pos[0];
            pos[1]=end>pos[1]?end:pos[1];
        }

    }

    private void searchRight(int start,int end,int target,int[] nums,int[] pos){
        while (end-start>1){
            if(nums[end]==target){
                pos[1]=end>pos[1]?end:pos[1];
                break;
            }else {
                int temp=(start+end)/2;
                if(nums[temp]>target){
                    end=temp;
                }else {
                    start=temp;
                }
            }
        }
        if(nums[start]==target){
            pos[1]=start>pos[1]?start:pos[1];
            pos[0]=start<pos[0]?start:pos[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5,7,7,8,8,8,10},5)));
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5,7,7,8,8,8,10},8)));
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5,7,7,8,8,8,10},10)));
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5,7,7,8,8,8,10},7)));
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5,7,7,8,8,8,10},2)));
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{2},11)));

    }

}
