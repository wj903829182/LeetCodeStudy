package com.jack.algorithm;

/**
 * create by jack 2018/10/20
 *
 * @auther jack
 * @date: 2018/10/20 10:10
 * @Description:
 */
public class LongestSubstring {
    /**
     * 题目描述：
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int maxLength =0;
        int length = s.length();
        String str = "";
        for (int i= 0;i<length;i++) {
            String s1 = String.valueOf(s.charAt(i));
            if (s1.length() > max) {
                max = s1.length();
            }
            for (int j=i+1;j<length;j++) {
                String s2 = String.valueOf(s.charAt(j));
                if (!s1.contains(s2)) {
                    s1 = s1 + s2;
                    maxLength = s1.length();
                    if (maxLength > max) {
                        max = maxLength;
                    }
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("pwwkew");
        System.out.println("length="+length);
    }
}
