package com.fz.leetcode.realize.medium;

import com.fz.leetcode.realize.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: fanzhen
 * @Date: 2019/12/19 14:13
 * @Version 2.0.0
 *
 * 二叉树层次输出
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> first=new LinkedList<>();
        first.offer(root);
        /*
            加入标记位
         */
        first.offer(null);
        List<Integer> temp=new LinkedList<>();
        while (!first.isEmpty()){
            TreeNode t=first.poll();
            if(t==null){
                if(!first.isEmpty()){
                    first.offer(null);
                }
                result.add(new ArrayList<>(temp));
                temp.clear();

            }else {
                temp.add(t.val);
                if(t.left!=null){
                    first.offer(t.left);
                }
                if(t.right!=null){
                    first.offer(t.right);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrderSecond(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            // start the current level
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // go to next level
            level++;
        }
        return levels;
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
        {
            levels.add(new ArrayList<Integer>());
        }

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
        {
            helper(node.left, level + 1);
        }
        if (node.right != null)
        {
            helper(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrderThird(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }
}
