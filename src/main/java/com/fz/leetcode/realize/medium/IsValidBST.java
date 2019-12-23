package com.fz.leetcode.realize.medium;

import com.fz.leetcode.realize.TreeNode;

import java.util.List;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 11:00
 * @Version 2.0.0
 *
 * 验证一棵树是否是二叉搜索树
 */
public class IsValidBST {

    public int pre=Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return search(root);
    }

    private boolean search(TreeNode root){
        if(root!=null){
            if(!search(root.left)){
                return false;
            }
            if(root.val<=pre){
                return false;
            }

            /*
                中序遍历的使用，前一个节点小于后一个节点
             */
            pre=root.val;
            if(!search(root.right)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(1);
        root.right=new TreeNode(7);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(8);
        System.out.println(new IsValidBST().isValidBST(root));
    }
}
