package com.jack.algorithm;

/**
 * create by jack 2018/10/23
 *
 * @auther jack
 * @date: 2018/10/23 22:13
 * @Description:
 * 字符串转换为整数
 */
public class StringToIntegerAtoi {

    /**
     * 题目描述：
     * https://leetcode.com/problems/string-to-integer-atoi/
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        //如果为null则直接返回
        if (str == null) {
            return 0;
        }
        //去掉字符串前后空格
        str=str.trim();
        if ("".equals(str)) {
            return 0;
        }
        //正负数标志，整数位true，负数为false,默认为true
        boolean flag = true;
        String s = "";
        int length = str.length();
        for (int i=0;i<length;i++) {
            //获取字符串的字符
            char c = str.charAt(i);
            //把字符转换为对应的数字
            int n = c-48;
            //判断字符串第一个字符是负号（-），还是正号（+）
            if (i == 0 && c =='-') {
                flag = false;
            } else if (i == 0 && c == '+') {
                flag = true;
            }
            //判断是否是0-9的数字
            if (n >= 0 && n < 10) {
                //字符拼接，方便后面转换为数字
                s = s + c;
            } else if (i == 0 && (c == '-' || c=='+')) {
                //判断第一个字符是否是加号或者减号，如果是则继续
                continue;
            } else {
                //如果字符不是数字，或者第一个字符不是减号或者加号则跳出循环
                break;
            }
        }
        //如果为空这直接返回0
        if ("".equals(s)) {
            return 0;
        }
        int length1 = s.length();
        long sum = 0;
        //字符串转换为int
        for (int i=0;i<length1;i++) {
            char c = s.charAt(i);
            int n = c-48;
            sum = sum *10+n;
            //如果是正数
            if (flag) {
                //大于Integer.MAX_VALUE，则直接返回Integer.MAX_VALUE
                if (sum > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else if (-sum < Integer.MIN_VALUE){
                //如果-sum小于Integer.MIN_VALUE，则直接返回Integer.MIN_VALUE
                return Integer.MIN_VALUE;
            }
        }
        if (!flag) {
            sum = -sum;
        }
        int rs =0;
        rs = (int) sum;
        return rs;
    }

    public static void main(String[] args) {
        //数字字符减去48得到数字
        int a = 'a'-48;
        int b = -2;
        //System.out.println(a);
        int n = myAtoi("9223372036854775808");
        System.out.println("n="+n);
        //int c = '.' - 48;
        //System.out.println(c);
    }
}
