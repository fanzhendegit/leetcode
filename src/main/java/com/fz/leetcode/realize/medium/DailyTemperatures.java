package com.fz.leetcode.realize.medium;

import java.util.Stack;

/**
 * @author fanzhen
 * @date 2020/2/7--14:31
 *
 * 每日温度
 * 计算最快几天升温
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        if(T==null||T.length==0){
            return new int[0];
        }
        int[] result=new int[T.length];
        Stack<Integer> temp=new Stack<>();
        Stack<Integer> index=new Stack<>();
        index.push(0);
        temp.push(T[0]);
        for (int i=1;i<T.length;i++){
                while (!temp.isEmpty()&&T[i]>temp.peek()){
                    temp.pop();
                    result[index.peek()]=i-index.pop();
                }
                temp.push(T[i]);
                index.push(i);
        }
        return result;
    }
}
