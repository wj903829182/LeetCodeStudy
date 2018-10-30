package com.jack.algorithm;

import java.util.Arrays;

/**
 * create by jack 2018/10/28
 *
 * @author jack
 * @date: 2018/10/28 21:42
 * @Description:
 */
public class ThreeSumClosest {

    /**
     * 题目描述：
     * https://leetcode.com/problems/3sum-closest/
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        //从小到大排序，三个数相加等于0，则最左边肯定是负数，最右边是正数
        Arrays.sort(nums);
        int i = 0;
        int closest = nums[0] + nums[1] + nums[2];
        int length = nums.length;
        while (i < length - 2) {
            int j = i + 1;
            int k = j + 1;
            while (j < length - 1) {
                k = j + 1;
                while (k < length) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int s1 = sum - target;
                    int s2 = closest - target;
                    if (s1 < 0) {
                        s1 = -s1;
                    }
                    if (s2 < 0) {
                        s2 = -s2;
                    }
                    if (s1 <= s2) {
                        closest = sum;
                    }
                    k++;
                }
                j++;

            }
            i++;
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        //int [] nums = new int[]{1,2,4,8,16,32,64,128};
        //int [] nums = new int[]{0,2,1,-3};


        int target = 1;
        //int target =82 ;
        //int target =1 ;
        int closest = threeSumClosest(nums, target);
        System.out.println("closest=" + closest);
    }

}
