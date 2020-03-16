package com.fz.leetcode.realize.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fanzhen
 * @date 2020/2/6--23:40
 *
 * 出现频率前K的数字
 */
public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> sum=new HashMap<>();
        List<Integer> result=new LinkedList<>();
        for (int n:nums){
            sum.merge(n, 1, Integer::sum);
        }
        List<Integer> t=sum.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        k=t.size()>k?t.get(k-1):0;
        for (Integer key:sum.keySet()){
            if(sum.get(key)>=k&&!result.contains(key)){
                result.add(key);
            }
        }
        return result;
    }
}
