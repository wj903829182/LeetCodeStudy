package com.jack.algorithm;

import sun.security.util.Length;

/**
 * create by jack 2019/5/4
 *
 * @author jack
 * @date: 2019/5/4 20:46
 * @Description:
 */
public class SearchInRotatedSortedArray {

    /**
     * 33-题目描述：
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int index = -1;
        for(int i=0,length = nums.length;i<length;i++){
            if (target == nums[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        //数组
        int[] nums = {4,5,6,7,0,1,2};
        //int[] nums = {4,5,6,7,0,1,2};
        //目标值
        int target = 0;
        //int target = 3;
        int index = search(nums,target);
        System.out.println("index="+index);

    }
}
