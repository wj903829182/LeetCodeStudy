package com.jack.algorithm;

/**
 * create by jack 2018/10/20
 *
 * @auther jack
 * @date: 2018/10/20 17:38
 * @Description:
 * 求两个有序数组的中位数
 */
public class MedianOfTwoSortedArrays {

    /**
     * 题目描述：
     * https://leetcode.com/problems/median-of-two-sorted-arrays/
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1+length2;
        int [] a = new int [length];
        double rs = 0;
        if (length1 == 0 && length2 >0) {
            for (int i=0;i<length2;i++) {
                a[i] = nums2[i];
            }
        } else if (length1 > 0 && length2 == 0) {
            for (int i=0;i<length1;i++) {
                a[i] = nums1[i];
            }
        } else if (length1 > 0 && length2 > 0) {
            int i = 0;
            int j = 0;
            for (int k=0;k<length;k++) {
                if (i >= length1 && j < length2) {
                    a[k] = nums2[j];
                    j++;
                    continue;
                }
                if (i < length1 && j >= length2) {
                    a[k] = nums1[i];
                    i++;
                    continue;
                }
                if (nums1[i] <= nums2[j]) {
                    if (i < length1) {
                        a[k] = nums1[i];
                        i++;
                    }
                } else {
                    if (j < length2) {
                        a[k] = nums2[j];
                        j++;
                    }
                }
            }
        }

        if (length % 2 == 0) {
            rs = (a[length/2-1]+a[length/2])/2.0;
        } else {
            rs = a[length/2];
        }
        return rs;
    }


    public static void main(String[] args) {
        int [] nums1 = new int[]{1,2};
        //int [] nums2 = new int[]{3,4};
        int [] nums2 = new int[]{3,4};
        double d = findMedianSortedArrays(nums1,nums2);
        System.out.println("中位数为："+d);
    }
}
