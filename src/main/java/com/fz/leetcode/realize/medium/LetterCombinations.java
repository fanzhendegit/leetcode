package com.fz.leetcode.realize.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 17:44
 * @Version 2.0.0
 *
 *  电话号码的字母组合
 *  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits==null||digits.length()==0){
            return result;
    }
        search("",digits,result);
        return result;
    }


    /**
     * 递归解法，往后循环
     * @param com
     * @param next_digits
     * @param result
     */
    private void search(String com,String next_digits,List<String> result){

        if(next_digits==null||next_digits.length()==0){
            result.add(com);
            return;
        }
        String cur=next_digits.substring(0,1);

        String temp=phone.get(cur);

        /*
            依次追加
         */
        for (int i=0;i<temp.length();i++){
            search(com+temp.charAt(i),next_digits.substring(1),result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }

}
