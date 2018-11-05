package com.jack.algorithm;

/**
 * create by jack 2018/11/5
 *
 * @author jack
 * @date: 2018/11/5 21:59
 * @Description:
 * 查找指定字符串在字符串的位置
 */
public class ImplementStrstr {

    /**
     * 题目描述：
     * https://leetcode.com/problems/implement-strstr/
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int i=0;
        int index = -1;
        for (;i<haystack.length();i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int t=i;
                int j=0;
                while (j < needle.length()) {
                    if (t<haystack.length() && needle.charAt(j) == haystack.charAt(t)) {
                        j++;
                        t++;
                    } else {
                        break;
                    }
                }
                if (j == needle.length()) {
                    index = i;
                    break;
                } else {
                    index = -1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        //String haystack = "hello";
        String haystack = "aaaaa";

        //String needle = "ll";
        String needle = "bba";
        int index = strStr(haystack,needle);
        System.out.println("index = "+index);
    }
}
