package com.fz.leetcode.realize.medium;

import java.util.Stack;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 17:23
 * @Version 2.0.0
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    public MinStack() {

    }

    Stack<Integer> data=new Stack<>();

    Stack<Integer> minStack=new Stack<>();

    public void push(int x) {
        data.push(x);
        if(minStack.isEmpty()||minStack.peek()>=x){
            minStack.push(x);
        }
    }

    public void pop() {
        if(data.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
