package com.jack.algorithm;

/**
 * create by jack 2018/10/22
 *
 * @auther jack
 * @date: 2018/10/22 23:32
 * @Description:
 * 反转整数
 */
public class ReverseInteger {
    /**
     * 题目描述:
     * https://leetcode.com/problems/reverse-integer/
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        long sum = 0;
        while (x > 0) {
            sum =sum*10 +x%10;
            x = x/10;
        }
        int rs = 0;
        if (flag) {
            sum = -sum;
        }
        //判断是否在指定的范围之内
        if (sum >= Integer.MIN_VALUE && sum <= Integer.MAX_VALUE) {
            rs = (int) sum;
        } else {
            //超出指定范围返回0
            rs = 0;
        }
        return rs;
    }


    public static void main(String[] args) {
        int num = reverse(123);
        System.out.println("num ="+num);
    }
}
