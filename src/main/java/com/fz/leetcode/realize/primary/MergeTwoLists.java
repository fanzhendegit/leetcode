package com.fz.leetcode.realize.primary;

import com.fz.leetcode.realize.ListNode;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 18:52
 * @Version 2.0.0
 *
 * 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    /**
     * 两个列表指针相互比较，小的追加到新列表，且指针后移
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(0);
        ListNode node1=node;
        while (l1!=null||l2!=null){
            if(l1==null||l2==null){
                if(l2!=null){
                    node1.next=l2;
                    break;
                }else {
                    node1.next=l1;
                    break;
                }
            }else {
                if(l1.val>l2.val){
                    node1.next=l2;
                    l2=l2.next;
                    node1=node1.next;
                }else {
                    node1.next=l1;
                    l1=l1.next;
                    node1=node1.next;
                }
            }
        }
        return node.next;
    }
}
