package com.fz.leetcode.realize.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: fanzhen
 * @Date: 2019/12/17 19:29
 * @Version 2.0.0
 *
 * 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        search(0,candidates,0,target,new ArrayList<>());
        return result;
    }

    private void search(int sum,int[] candidates, int index,int target,List<Integer> temp){
        if(sum==target){
            result.add(new ArrayList<>(temp));
        }else if(sum<target) {
            for (int i = index; i < candidates.length; i++) {
                if (sum + candidates[i] <= target) {
                    temp.add(candidates[i]);
                    search(sum + candidates[i], candidates, i, target, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7},7));
    }

}
