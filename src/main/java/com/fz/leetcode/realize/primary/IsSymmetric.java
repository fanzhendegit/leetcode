package com.fz.leetcode.realize.primary;

import com.fz.leetcode.realize.TreeNode;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 14:01
 * @Version 2.0.0
 *
 * 是否为镜像树
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return symmetric(root.right,root.left);
    }

    private boolean symmetric(TreeNode left,TreeNode right){
        if(left==null||right==null){
            return left == null && right == null;
        }else {
            if(left.val==right.val){
                /*
                    递归判断
                 */
                if(!symmetric(left.left,right.right)){
                    return false;
                }
                return symmetric(left.right, right.left);
            }else {
                return false;
            }
        }
    }
}
