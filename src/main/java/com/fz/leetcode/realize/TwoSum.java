package com.fz.leetcode.realize;

import com.fz.leetcode.ApplicationOne;
import org.springframework.boot.SpringApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 10:44
 * @Version 2.0.0
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    /**
     * 暴力法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] position=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    position[0]=i;
                    position[1]=j;
                    break;
                }
            }
        }
        return position;
    }


    public int[] twoSumSecond(int[] nums, int target) {
        Map<Integer,Integer> position=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            Integer temp=position.get(target-nums[i]);
            if(temp!=null){
                /**
                 * 一定是i后进来
                 */
                return new int[]{temp,i};
            }else {
                position.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums=new int[]{3,2,4};
        System.out.println(Arrays.toString(new TwoSum().twoSumSecond(nums,6)));
    }


}
