package com.fz.leetcode.realize.medium;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 17:03
 * @Version 2.0.0
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    /**
     * 暴力法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                int temp=nums[i]+nums[j]+nums[k];
                /*
                    如果大于的话K向前，或者说k下标的值重复过了，那么直接去除就好了
                 */
                if(temp>0||(k<nums.length-1&&nums[k]==nums[k+1])){
                    k--;
                }
                /*
                    如果小于的话J向后，或者说J下标的值重复过了，那么直接去除就好了
                 */
                else if(temp<0||(j>i+1&&nums[j]==nums[j-1])){
                    j++;
                }else {
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return  result;
    }

    public List<List<Integer>> threeSumSecond(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>0){
                break;
            }
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                if(nums[k]<0){
                    break;
                }
                int temp=nums[i]+nums[j]+nums[k];
                /*
                    如果大于的话K向前，或者说k下标的值重复过了，那么直接去除就好了
                 */
                if(temp>0||(k<nums.length-1&&nums[k]==nums[k+1])){
                    k--;
                }
                /*
                    如果小于的话J向后，或者说J下标的值重复过了，那么直接去除就好了
                 */
                else if(temp<0||(j>i+1&&nums[j]==nums[j-1])){
                    j++;
                }else {
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return  result;
    }

}
