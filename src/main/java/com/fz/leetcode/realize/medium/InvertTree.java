package com.fz.leetcode.realize.medium;

import com.fz.leetcode.realize.TreeNode;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 18:13
 * @Version 2.0.0
 *
 * 翻转一棵二叉树。
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
