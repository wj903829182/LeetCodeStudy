package com.jack.algorithm;

import javax.sql.rowset.FilteredRowSet;

/**
 * create by jack 2019/5/4
 *
 * @author jack
 * @date: 2019/5/4 21:38
 * @Description:
 */
public class SearchInsertPosition {

    /**
     * 35-题目描述：
     * https://leetcode.com/problems/search-insert-position/
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i=0,length = nums.length;i<length;i++) {
            if (nums[i] == target){
                index = i;
                break;
            } else if (nums[i] > target) {
                index = i;
                break;
            } else if (target > nums[i] && i == length-1) {
                index = i+1;
                break;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        //int [] nums = {1,3,5,6};
        //int [] nums = {1,3,5,6};
        //int [] nums = {1,3,5,6};
        int [] nums = {1,3,5,6};

        //int target = 5;
        //int target = 2;
        //int target = 7;
        int target = 0;

        int index = searchInsert(nums,target);
        System.out.println("index="+index);
    }
}
