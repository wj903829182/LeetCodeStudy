package com.jack.algorithm;

/**
 * create by jack 2018/11/5
 *
 * @author jack
 * @date: 2018/11/5 21:32
 * @Description:
 * 求去掉指定元素以后，新数组的长度
 */
public class RemoveElement {


    /**
     * 题目描述：
     * https://leetcode.com/problems/remove-element/
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int i=0;
        for (int j=0;j<nums.length;j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{3,2,2,3};
        //int[] nums = new int[]{3,2,2,3};
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        //int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int v = 2;
        int length =removeElement(nums,v);
        System.out.println("length="+length);
    }
}
