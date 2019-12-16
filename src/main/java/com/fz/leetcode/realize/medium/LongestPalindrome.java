package com.fz.leetcode.realize.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 15:50
 * @Version 2.0.0
 *
 * 最长回文串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {

    /**
     * 暴力法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s==null||s.length()<2){
            return s;
        }
        Map<Integer,Integer> index=new HashMap<>();
        int max=0;
        for (int i=0;i<s.length();i++){
            for (int j=s.length()-1;j>i-1;j--){
                if(s.charAt(i)==s.charAt(j)){
                    int iTemp=i;
                    int jTemp=j;
                    while (iTemp<jTemp){
                        if(s.charAt(iTemp)!=s.charAt(jTemp)){
                            break;
                        }
                        iTemp++;
                        jTemp--;
                    }
                    if(iTemp==jTemp||iTemp>jTemp){
                        if((j-i+1>max)||(j-i+1==max)){
                            index.put(i,j);
                            max=j-i+1;
                        }
                    }
                }
                if(max==s.length()){
                    break;
                }
            }
            if(max==s.length()){
                break;
            }
        }
        //List<String> result=new ArrayList<>();
        String result=null;
        for (Integer first:index.keySet()){
            if(index.get(first)-first+1!=max){
                continue;
            }
            if(index.get(first)>s.length()-1){
                result=s.substring(first);
                //result.add(s.substring(first));
            }else {
                result=s.substring(first,index.get(first)+1);
                //result.add(s.substring(first,index.get(first)+1));
            }
        }
        return result;
    }


    /**
     * 中心扩展算法
     * @param s
     * @return
     */
    public String longestPalindromeSecond(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            /*
                以一个字母为核心的回文长度计算
             */
            int len1 = expandAroundCenter(s, i, i);

            /*
                以两个字母为核心的回文长度计算
             */
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
