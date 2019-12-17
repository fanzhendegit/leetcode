package com.fz.leetcode.realize.medium;

import java.util.*;

/**
 * @Author: fanzhen
 * @Date: 2019/12/17 19:56
 * @Version 2.0.0
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Permute {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        search(nums,nums.length,0,new LinkedList<>());
        return result;
    }

    private void search(int[] nums, int len, int size, List<Integer> temp){
        if(size==len){
            result.add(new ArrayList<>(temp));
        }else if(size<len){
            for (int i:nums){
                if(!temp.contains(i)){
                    temp.add(i);
                    search(nums,len,temp.size(),temp);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1,2,3}));
    }
}
