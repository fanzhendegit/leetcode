package com.fz.leetcode.realize.medium;

import com.fz.leetcode.realize.primary.TwoSum;

import java.util.*;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 14:46
 * @Version 2.0.0
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {

    /**
     * 暴力法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int max=0;
        byte[] bytes=s.getBytes();

        /*
            根据HashSet判断
         */
        Set<Byte> bytes1=new HashSet<>();
        for (int i=0;i<bytes.length;i++){
            bytes1.clear();
            int length=0;
            for (int j=i;j<bytes.length;j++){
                if(!bytes1.contains(bytes[j])){
                    bytes1.add(bytes[j]);
                    length++;
                }else {
                    break;
                }
            }
            max=Math.max(max,length);
        }
        return max;
    }

    public int lengthOfLongestSubstringSecond(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int max=0,n=s.length();
        for (int j = 0, i = 0; j < n; j++) {

            /*
                若字母重复的话，则更新窗口起始值
             */
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }

            /*
                选取最大值
             */
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstringSecond(new String("abba")));
    }
}
