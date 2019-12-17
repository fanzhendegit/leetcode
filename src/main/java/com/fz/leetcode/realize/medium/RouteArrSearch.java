package com.fz.leetcode.realize.medium;

/**
 * @Author: fanzhen
 * @Date: 2019/12/17 17:01
 * @Version 2.0.0
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RouteArrSearch {

    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=(left+right)/2;
        while (right-left>1){
            if(nums[mid]==target){
                return mid;
            }else if(nums[left]==target){
                return left;
            }else if(nums[right]==target){
                return right;
            } else{
                /*
                    如果满足中间小，最左边小，那么证明是右边是可以抛弃的
                 */
                if(nums[left]<target&&nums[mid]<target){
                    right=mid;
                }else if(nums[mid]>target&&nums[right]>target){
                    left=mid;
                }else {
                    left++;
                    right--;
                }
                mid=(left+right)/2;
            }
        }
        if(nums[left]==target){
            return left;
        }else if(nums[right]==target){
            return right;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(new RouteArrSearch().search(new int[]{4,5,6,7,0,1,2},4));
        System.out.println(new RouteArrSearch().search(new int[]{4,5,6,7,0,1,2},5));
        System.out.println(new RouteArrSearch().search(new int[]{4,5,6,7,0,1,2},6));
        System.out.println(new RouteArrSearch().search(new int[]{4,5,6,7,0,1,2},7));
        System.out.println(new RouteArrSearch().search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(new RouteArrSearch().search(new int[]{4,5,6,7,0,1,2},1));
        System.out.println(new RouteArrSearch().search(new int[]{4,5,6,7,0,1,2},2));
        System.out.println(new RouteArrSearch().search(new int[]{4,5,6,7,0,1,2},3));


    }

}
