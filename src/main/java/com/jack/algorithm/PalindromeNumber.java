package com.jack.algorithm;

/**
 * create by jack 2018/10/23
 *
 * @auther jack
 * @date: 2018/10/23 23:48
 * @Description:
 * 判断一个整数是否是回文数
 */
public class PalindromeNumber {

    /**
     * 题目描述：
     *
     * https://leetcode.com/problems/palindrome-number/
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        //如果是负数直接返回，肯定不是回文数
        if (x < 0) {
            return false;
        }
        int sum =0;
        int y = x;
        while (y!=0) {
            sum = sum *10 +y%10;
            y=y/10;
        }
        //重新组装的数和原先的相等，则返回true，否则返回false
        if (sum == x) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        boolean flag = isPalindrome(0);
        System.out.println("flag="+flag);
    }
}
