package com.fz.leetcode.realize.medium;

import com.fz.leetcode.realize.ListNode;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 18:22
 * @Version 2.0.0
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        /*
            从head前一个开始，是为了删除head节点
         */
        ListNode node=new ListNode(0);
        node.next=head;
        ListNode pre=node,last=node;
        for(int i=0;i<n;i++){
            last=last.next;
        }
        while (last.next!=null){
            pre=head.next;
            last=last.next;
        }

        /*
            将pre的下一个节点删除
         */
        pre.next=pre.next.next;
        return node.next;

    }
}
