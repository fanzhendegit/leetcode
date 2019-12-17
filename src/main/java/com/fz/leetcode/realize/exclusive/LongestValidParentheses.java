package com.fz.leetcode.realize.exclusive;

import java.util.Stack;

/**
 * @Author: fanzhen
 * @Date: 2019/12/17 15:26
 * @Version 2.0.0
 *
 * 最长有效括号
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        Stack<String> stringStack=new Stack<>();

        for (int i=0;i<s.length();i++){
            /*
                空栈压入
             */
            if(stack.size()==0){
                stack.push(i);
                stringStack.push(s.substring(i,i+1));
            }else {

                if(")".equals(s.substring(i, i + 1)) && "(".equals(stringStack.peek())){
                    stringStack.pop();
                    stack.pop();
                }else {

                    stringStack.push(s.substring(i,i+1));
                    stack.push(i);
                }
            }
        }
        int max=0;
        if(stack.size()==0){
            return s.length();
        }else if(stack.peek()!=s.length()-1){
            stack.push(s.length());
        }else {
            stack.push(s.length()-1);
        }

        if(stack.size()==1){
            return s.length();
        }else {
            while (stack.size()!=1){
                int temp=stack.pop()-stack.peek()-1;
                if(temp>max){
                    max=temp;
                }
            }
        }
        stack.size();
        int temp=stack.pop();
        if(temp>max){
            max=temp;
        }
        return max;
    }

    public int longestValidParenthesesSecond(String s) {
        int max=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        for (int i=0;i<s.length();i++){

            /*
                左括号入栈
             */
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();

                /*
                    空栈则表明之前的字符串已经无法和后面的串形成有效字符串了，从当前位置开始
                 */
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    /*
                        计算长度，取最大值
                     */
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }


}
