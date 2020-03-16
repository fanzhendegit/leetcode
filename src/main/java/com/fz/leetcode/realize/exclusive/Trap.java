package com.fz.leetcode.realize.exclusive;

/**
 * @author fanzhen
 * @date 2020/2/6--16:00
 *
 * 接雨水
 * 解题思路，两遍动态规划，左边一次，右边一次
 */
public class Trap {

    public int trap(int[] height) {
        if(height==null||height.length<2){
            return 0;
        }
        int length=height.length;

        int[] left=new int[length];
        int[] right=new int[length];

        left[0]=height[0];
        right[length-1]=height[length-1];

        int leftMax=height[0];
        int rightMax=height[length-1];

        for (int i=1;i<length;i++){
            /*
                寻找左边的最大值，比较i-1之前的和i-1位置
             */
            leftMax= Math.max(leftMax, height[i - 1]);

            /*
                判断当前是峰谷还是开始下坡，取最大值
             */
            left[i]= Math.max(height[i], leftMax);

            /*
                寻找右边的最大值，比较length-i-1之前的和length-i位置
             */
            rightMax=Math.max(rightMax,height[length-i]);

            /*
                同理，判断当前是峰谷还是开始下坡，取最大值
             */
            right[length-i-1]= Math.max(height[length-i-1], rightMax);
        }
        int sum=0;
        for (int i=0;i<length;i++){
            int temp;
            if(left[i]<right[i]){
                temp=(left[i]-height[i]);
            }else {
                temp=(right[i]-height[i]);
            }
            sum=sum+temp;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(new Trap().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
