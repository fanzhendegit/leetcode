package com.fz.leetcode.realize.primary;

import com.fz.leetcode.realize.ListNode;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 17:31
 * @Version 2.0.0
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int stepA=0;
        int stepB=0;
        ListNode headANext=headA;
        ListNode headBNext=headB;
        while (headANext!=null){
            headANext=headANext.next;
            stepA++;
        }
        while (headBNext!=null){
            headBNext=headBNext.next;
            stepB++;
        }
        if(stepA>stepB){
            for (int i=0;i<stepA-stepB;i++){
                headA=headA.next;
            }
        }else {
            for (int i=0;i<stepB-stepA;i++){
                headB=headB.next;
            }
        }
        while (headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }

}
