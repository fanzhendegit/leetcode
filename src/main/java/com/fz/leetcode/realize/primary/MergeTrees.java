package com.fz.leetcode.realize.primary;

import com.fz.leetcode.realize.TreeNode;

/**
 * @author fanzhen
 * @date 2020/2/7--14:28
 *
 * 两棵树合并
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
