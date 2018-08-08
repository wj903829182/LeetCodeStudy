package com.jack.algorithm;

import com.alibaba.fastjson.JSONObject;

/**
 * create by jack 2018/8/8
 *
 * @auther jack
 * @date: 2018/8/8 22:25
 * @Description:
 * 两数之和
 */
public class SumTwoNum {
    //题目描述：https://leetcode-cn.com/problems/two-sum/description/
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        SumTwoNum twoNum = new SumTwoNum();
        System.out.println(JSONObject.toJSONString(twoNum.twoSum(new int[]{2, 7, 11, 15},9)));
    }


}
