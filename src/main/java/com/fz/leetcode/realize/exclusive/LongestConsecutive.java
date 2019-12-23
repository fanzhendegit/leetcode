package com.fz.leetcode.realize.exclusive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 16:09
 * @Version 2.0.0
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int temp=1,max=1;
        for (int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]-nums[i-1]==1){
                temp++;
                max=Math.max(temp,max);
            }else {
                temp=1;
            }
        }
        return max;
    }

    public int longestConsecutiveSecond(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            /*
                如果前一个存在则证明已经算在队列了，直接跳过
             */
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args){
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{1,1}));
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{1,2,4,5,6,7,8}));
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{9,3,5,7,4,1,2,0}));
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{}));



    }
}
