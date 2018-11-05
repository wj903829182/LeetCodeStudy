package com.jack.algorithm;

/**
 * create by jack 2018/11/4
 *
 * @author jack
 * @date: 2018/11/4 22:16
 * @Description:
 * 数组里面不同元素的个数
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 题目描述：
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }



    public static void main(String[] args) {
        int[] nums1 =new int[]{1,1,2};
        //int[] nums1 =new int[]{0,0,1,1,1,2,2,3,3,4};
        //int[] nums1 =new int[]{0,0,1,1,1,2,2,3,3,4};

        int num = removeDuplicates(nums1);
        System.out.println("num = "+num);
    }
}
