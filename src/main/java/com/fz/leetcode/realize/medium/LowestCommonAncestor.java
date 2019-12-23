package com.fz.leetcode.realize.medium;

import com.fz.leetcode.realize.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 18:22
 * @Version 2.0.0
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先
 * 且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode tempP=null;
        TreeNode tempQ=null;
        Stack<TreeNode> stack=new Stack<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        /*
            层次遍历压入栈中
         */
        while (tempP==null||tempQ==null){
            TreeNode l=queue.poll();
            if(l==null){
                break;
            }
            if(l.left!=null){
                queue.offer(l.left);
            }
            if(l.right!=null){
                queue.offer(l.right);
            }
            if(l==p){
                tempP=l;
            }
            if(l==q){
                tempQ=l;
            }
            stack.push(l);
        }

        if(tempP==tempQ){
            return tempP;
        }

        /*
            倒出栈，并且向上标记，直至标记位相遇
         */
        while (!stack.isEmpty()){
            if(tempP==tempQ){
                return tempP;
            }
            TreeNode t=stack.pop();
            if(t==tempP||t.left==tempP||t.right==tempP){
                tempP=t;
            }
            if(t==tempQ||t.left==tempQ||t.right==tempQ){
                tempQ=t;
            }
        }
        return root;
    }
}
