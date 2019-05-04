package com.jack.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * create by jack 2019/5/4
 *
 * @author jack
 * @date: 2019/5/4 14:15
 * @Description:
 */
public class NextPermutation {

    /**
     * 31-题目描述
     * https://leetcode.com/problems/next-permutation/
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        for(int i = nums.length - 2 ; i>=0 ; i--){
            //寻找可以替换的最低位
            for(int j = i+1 ; j<nums.length ; j++){
                if(nums[i]<nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    //确保替换位的后续位的值最小
                    Arrays.sort(nums, i+1, nums.length);
                    return;
                }
            }
            //若当前位不可替换，则自当前位开始排序，以保证下一位可以在不进行完整遍历的前提下找到最小的更大值
            Arrays.sort(nums,i,nums.length);
        }
    }

    /**
     * 交替数组中两个下标对应的值
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int []nums,int i,int j) {
        int t = nums[i];
        nums[i] =  nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        //int[] nums ={1,2,3};
        int[] nums ={1,2,7,4,3,1};
        nextPermutation(nums);
        System.out.println(JSONObject.toJSONString(nums));
    }
}
