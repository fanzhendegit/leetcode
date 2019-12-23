package com.fz.leetcode.realize.primary;

import com.fz.leetcode.realize.ListNode;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 18:04
 * @Version 2.0.0
 *
 * 反转一个单链表。
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
