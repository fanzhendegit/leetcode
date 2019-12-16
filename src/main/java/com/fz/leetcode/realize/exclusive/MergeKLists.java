package com.fz.leetcode.realize.exclusive;

import com.fz.leetcode.realize.ListNode;
import com.fz.leetcode.realize.primary.MergeTwoLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 19:12
 * @Version 2.0.0
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class MergeKLists {

    /**
     * 两两合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        MergeTwoLists mergeTwoLists=new MergeTwoLists();
        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }else if(lists.length==2){
            return mergeTwoLists.mergeTwoLists(lists[0],lists[1]);
        }

        List<ListNode> nodeList = new ArrayList<>(Arrays.asList(lists));
        while (nodeList.size()!=1){
            nodeList.add(mergeTwoLists.mergeTwoLists(nodeList.get(0),nodeList.get(1)));
            nodeList.remove(0);
            nodeList.remove(0);
        }
        return nodeList.get(0);
    }


    /**
     * 分治算法，八变四，四变二
     * @param lists
     * @return
     */
    public ListNode mergeKListsSecond(ListNode[] lists) {
        MergeTwoLists mergeTwoLists=new MergeTwoLists();
        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }else if(lists.length==2){
            return mergeTwoLists.mergeTwoLists(lists[0],lists[1]);
        }

        List<ListNode> nodeList = new ArrayList<>(Arrays.asList(lists));
        while (nodeList.size()!=1){
            int size=nodeList.size()-1;
            List<ListNode> temp=new ArrayList<>();
            for (int i=0;i<=size/2;i++){
                if(i<size-i){
                    temp.add(mergeTwoLists.mergeTwoLists(nodeList.get(i),nodeList.get(size-i)));
                }else if(i==size-i){
                    temp.add(nodeList.get(i));
                }
            }
            nodeList=temp;
        }
        return nodeList.get(0);
    }
}
