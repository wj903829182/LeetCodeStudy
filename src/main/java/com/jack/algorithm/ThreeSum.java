package com.jack.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * create by jack 2018/10/28
 *
 * @author jack
 * @date: 2018/10/28 19:43
 * @Description:
 */
public class ThreeSum {

    /**
     * 题目描述：
     *https://leetcode.com/problems/3sum/
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return rs;
        }
        //从小到大排序，三个数相加等于0，则最左边肯定是负数，最右边是正数
        Arrays.sort(nums);
        int i=0;
        while(i < nums.length - 2) {
            if(nums[i] > 0){
                break;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    rs.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                if (sum <= 0) {
                    while (nums[j] == nums[++j] && j < k) ;
                }
                if (sum >= 0) {
                    while (nums[k--] == nums[k] && j < k) ;
                }
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return rs;
    }



    public static boolean hasSame(List<List<Integer>> list){
        if(null == list)
            return false;
        return list.size() != new HashSet<Object>(list).size();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSum = threeSum(nums);
        System.out.println("threeSum="+ JSONObject.toJSONString(threeSum));
    }
}
