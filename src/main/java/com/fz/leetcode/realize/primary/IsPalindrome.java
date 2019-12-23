package com.fz.leetcode.realize.primary;

import com.fz.leetcode.realize.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 18:21
 * @Version 2.0.0
 *
 *
 * 是否为回文链表
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        /*
            一个队列一个栈，一前一后
         */
        Stack<ListNode> stack=new Stack<>();
        Queue<ListNode> queue=new LinkedList<>();
        while (head!=null){
            stack.push(head);
            queue.offer(head);
            head=head.next;
        }
        while (!stack.isEmpty()){
            if(stack.pop().val!=queue.poll().val){
                return false;
            }
        }
        return true;
    }
}
