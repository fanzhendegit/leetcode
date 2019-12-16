package com.fz.leetcode.realize.medium;

import com.fz.leetcode.realize.ListNode;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 11:47
 * @Version 2.0.0
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
            保存头节点
         */
        ListNode l4=new ListNode(0);

        /*
            l3向后遍历
         */
        ListNode l3=l4;
        int pre=0;
        while (l1!=null||l2!=null){
            /*
                为空即为0,也可以后面加判断，不新建对象，减少空间使用
             */
            if(l1==null){
                l1=new ListNode(0);
            }
            if(l2==null){
                l2=new ListNode(0);
            }

            /*
                相加，过十加一
             */
            int val=l1.val+l2.val+pre;
            if(val>9){
                val=val-10;
                pre=1;
            }else {
                pre=0;
            }

            /*
                继续向后
             */
            l3=new ListNode(val);
            l3=l3.next;
            l1=l1.next;
            l2=l2.next;
        }
        if(pre!=0){
            l3.next= new ListNode(pre);
        }
        return l4.next;
    }
}
