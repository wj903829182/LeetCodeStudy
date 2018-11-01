package com.jack.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * create by jack 2018/10/31
 *
 * @author jack
 * @date: 2018/10/31 22:34
 * @Description:
 */
public class FourSum {

    /**
     *题目描述：
     * https://leetcode.com/problems/4sum/
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        if (nums == null && nums.length < 4) {
            return rs;
        }
        Arrays.sort(nums);
        int i=0,j=0,k=0,n=0;
        int length = nums.length;
        Map<String, List<Integer>> map = new HashMap<>();
        for (i=0;i<length-3;i++) {
            //first candidate too large, search finished
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //prevents duplicate result in ans list
            if(i>0&&nums[i]==nums[i-1])continue;
            for (j=i+1;j<length-2;j++) {
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;
                if (j > i+1 && nums[j] == nums[j - 1]) continue;
                int  start = j+1;
                int end = nums.length-1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        List<Integer> list=new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        rs.add(list);
                        start++;
                        end--;
                        while(start<end &&nums[end]==nums[end+1] ){
                            end--;
                        }

                        while(start<end &&nums[start]==nums[start-1]){
                            start++;
                        }
                    }else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }

                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        //int[] nums = new int []{1, 0, -1, 0, -2, 2};
        //int[] nums = new int []{-3,-2,-1,0,0,1,2,3};
        int[] nums = new int []{-5,5,4,-3,0,0,4,-2};
        List<List<Integer>> list = fourSum(nums,4);
        System.out.println("list="+ JSONObject.toJSONString(list));
    }
}
