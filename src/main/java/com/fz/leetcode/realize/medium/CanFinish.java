package com.fz.leetcode.realize.medium;

import java.util.LinkedList;

/**
 * @author fanzhen
 * @date 2020/2/7--13:38
 *
 * 课程表，N门课程，数组表示完成该课程之前需要完成的其他课程号，计算是否可以学习完成
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) {
                queue.addLast(i);
            }
        }
        while(!queue.isEmpty()) {
            /*
                将入度为0的全部舍弃
             */
            Integer pre = queue.removeFirst();
            numCourses--;
            for(int[] req : prerequisites) {
                if(req[1] != pre) {
                    continue;
                }
                if(--indegrees[req[0]] == 0) {
                    queue.add(req[0]);
                }
            }
        }
        return numCourses == 0;
    }
}
