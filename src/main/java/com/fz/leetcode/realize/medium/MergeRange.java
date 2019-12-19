package com.fz.leetcode.realize.medium;

import java.util.*;

/**
 * @Author: fanzhen
 * @Date: 2019/12/18 11:19
 * @Version 2.0.0
 *
 * 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeRange {

    public int[][] merge(int[][] intervals) {
        //sort(intervals);
        Arrays.sort(intervals,new IntervalComparator());
        List<int[]> integerList=new ArrayList<>();
        for (int[] interval : intervals) {
            if (integerList.size() == 0) {
                integerList.add(interval);
            } else {
                /*
                    与列表的最后一个元素进行比较
                 */
                int temp = integerList.get(integerList.size() - 1)[1];
                if (temp < interval[0]) {
                    integerList.add(interval);
                } else {
                    if (temp < interval[1]) {
                        integerList.get(integerList.size() - 1)[1] = interval[1];
                    }
                }
            }
        }
        int[][] result=new int[integerList.size()][2];
        integerList.toArray(result);
        return result;
    }

    /**
     *  继承Comparator接口进行比较
     */
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }

    private void sort(int[][] intervals) {
        for (int i=0;i<intervals.length-1;i++){
            for (int j=i+1;j<intervals.length;j++){
                if(intervals[i][0]>intervals[j][0]){
                    int[] temp=intervals[i];
                    intervals[i]=intervals[j];
                    intervals[j]=temp;
                }
            }
        }
    }
}
