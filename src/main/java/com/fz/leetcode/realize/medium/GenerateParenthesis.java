package com.fz.leetcode.realize.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 18:59
 * @Version 2.0.0
 *
 * 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class GenerateParenthesis {

    private List<String> generateParenthesisResult=new LinkedList<>();


    /**
     * 递归解法
     * @param s
     * @param m
     * @param n
     * @param max
     */
    public void generateParenthesisTemp(String s,int m,int n,int max){
        if(s.length()==max*2) {
            generateParenthesisResult.add(s.toString());
            return;
        }
        /*
            先压入左括号
         */
        if(m<max){
            generateParenthesisTemp(s+"(",m+1,n,max);
        }

        /*
            压入比左括号小的右括号
         */
        if(n<m){
            generateParenthesisTemp(s+")",m,n+1,max);
        }
    }

    public List<String> generateParenthesis(int n) {
        generateParenthesisTemp("",0,0,n);
        return generateParenthesisResult;
    }
}
