package com.fz.leetcode.realize.medium;

import com.fz.leetcode.realize.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 10:32
 * @Version 2.0.0
 *
 * 中序遍历
 *
 * 给定一个二叉树，返回它的中序遍历。
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        inorder(root,result);
        return result;
    }

    private void inorder(TreeNode root,List<Integer> result){
        if(root!=null){
            inorder(root.left,result);
            result.add(root.val);
            inorder(root.right,result);
        }
    }

}
