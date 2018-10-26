package com.jack.algorithm;

/**
 * create by jack 2018/10/26
 *
 * @auther jack
 * @date: 2018/10/26 22:39
 * @Description: 水容器的最大值
 */
public class ContainerWithMostWater {


    /**
     * 题目描述：
     * https://leetcode.com/problems/container-with-most-water/
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        //最大值
        int max = 0;
        //数组长度
        int length = height.length;
        //计算容器最大值，依次比较
        for (int i = 0; i < length - 1; i++) {
            int h1 = height[i];
            for (int j = i + 1; j < length; j++) {
                int h2 = height[j];
                int w = j - i;
                if (h1 >= h2) {
                    if (max < h2 * w) {
                        max = h2 * w;
                    }
                } else {
                    if (max < h1 * w) {
                        max = h1 * w;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        int c = maxArea(a);
        System.out.println("c = "+c);
    }
}
