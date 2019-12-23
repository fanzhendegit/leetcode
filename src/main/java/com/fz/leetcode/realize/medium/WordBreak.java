package com.fz.leetcode.realize.medium;

import java.util.*;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 16:38
 * @Version 2.0.0
 *
 * 单词拆分
 *
 * 给定一个字符串和字典，判断字符串是否可以被空格分割为字典中的单次，可以出现1到N次
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0){
            return true;
        }
        for (int j=0;j<=s.length();j++){
            String temp=s.substring(0,j);
            if(wordDict.contains(temp)&&wordBreak(s.substring(j),wordDict)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        List<String> stringList=new ArrayList<String>();
        stringList.add("cats");
        stringList.add("send");
        System.out.println(new WordBreak().wordBreak("catsend",stringList));
    }

    public boolean wordBreakSecond(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    private boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                /*
                    标记
                 */
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }


}
