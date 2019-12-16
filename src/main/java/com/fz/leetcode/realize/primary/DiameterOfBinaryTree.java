package com.fz.leetcode.realize.primary;

import com.fz.leetcode.realize.TreeNode;

/**
 * @Author: fanzhen
 * @Date: 2019/12/16 11:37
 * @Version 2.0.0
 *
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 */
public class DiameterOfBinaryTree {

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    /**
     * 计算
     * @param node
     * @return
     */
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        /*
            计算左结点最大深度
         */
        int L = depth(node.left);

        /*
            计算右节点最大深度
         */
        int R = depth(node.right);

        /*
            取最大值
         */
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}
