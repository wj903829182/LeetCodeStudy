package com.jack.algorithm;

import com.alibaba.fastjson.JSONObject;

/**
 * create by jack 2019/5/4
 *
 * @author jack
 * @date: 2019/5/4 21:21
 * @Description:
 */
public class FindFirstandLastPositionOfElementInSortedArray {

    /**
     *34-题目描述：
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] indexs = {-1, -1};
        for (int i=0,length=nums.length;i<length;i++) {
            if (target == nums[i]) {
                if (indexs[0] == -1) {
                    indexs[0] = i;
                    indexs[1] = i;
                } else {
                    indexs[1] = i;
                }

            }
        }
        return indexs;
    }

    public static void main(String[] args) {
        //int[] nums = {5,7,7,8,8,10};
        int[] nums = {5,7,7,8,8,10};

        //int target = 8;
        int target = 6;
        int [] indexs = searchRange(nums,target);
        System.out.println("indexs="+ JSONObject.toJSONString(indexs));
    }
}
