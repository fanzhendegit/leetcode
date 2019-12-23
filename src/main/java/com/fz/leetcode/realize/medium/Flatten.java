package com.fz.leetcode.realize.medium;

import com.fz.leetcode.realize.TreeNode;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 15:16
 * @Version 2.0.0
 *
 * 二叉树展开为列表
 *
 * 给定一个二叉树，原地将它展开为链表。
 */
public class Flatten {


    TreeNode pre=null;
    /*
        从右边第一个节点开始，依次附着
     */
    public void flatten(TreeNode root) {
        if(root!=null){
            flatten(root.right);
            flatten(root.left);
            root.right=pre;
            root.left=null;
            pre=root;
        }
    }
}
