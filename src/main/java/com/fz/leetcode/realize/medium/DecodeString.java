package com.fz.leetcode.realize.medium;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author fanzhen
 * @date 2020/2/7--10:19
 */
public class DecodeString {

    public String decodeString(String s) {
        /*
            记录字符串
         */
        StringBuilder res = new StringBuilder();

        /*
            用于计算乘数
         */
        int multi = 0;

        /*
            乘数栈
         */
        LinkedList<Integer> stack_multi = new LinkedList<>();

        /*
            记录存放的字符串
         */
        LinkedList<String> stack_res = new LinkedList<>();


        for(Character c : s.toCharArray()) {

            /*
                '['开头时，乘数归零，最后一个乘数入栈，前面的字符串入栈
             */
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }

            /*
                ']'开头时，res开始累加，并重置为上一个括号内的字符串
             */
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }

            /*
                累乘数字
             */
            else if(c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            }
            else {
                /*
                    记录字符
                 */
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    }
}
