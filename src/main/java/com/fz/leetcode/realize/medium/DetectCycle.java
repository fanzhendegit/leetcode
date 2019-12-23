package com.fz.leetcode.realize.medium;

import com.fz.leetcode.realize.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 17:19
 * @Version 2.0.0
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if(head==null) {
            return null;
        }

        Set<ListNode> listNodes=new HashSet<>();
        listNodes.add(head);
        head=head.next;
        while (head!=null){
            if(listNodes.contains(head))
            {
                return head;
            }
            listNodes.add(head);
            head=head.next;
        }
        return null;
    }
}
