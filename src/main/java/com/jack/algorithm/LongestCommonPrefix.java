package com.jack.algorithm;

/**
 * create by jack 2018/10/28
 *
 * @author jack
 * @date: 2018/10/28 13:35
 * @Description:
 * 求字符串数组，所有元素的最大相同字符
 */
public class LongestCommonPrefix {

    /**
     * 题目描述：
     * https://leetcode.com/problems/longest-common-prefix/
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String rs = "";
        String s1 = strs[0];
        for (int i=0;i<s1.length();i++) {
            char c = s1.charAt(i);
            if (prefixMatch(c, i, strs)) {
                rs += c;
            } else {
                break;
            }
        }
        return rs;
    }

    public static boolean prefixMatch(char c,int j,String[] strs){
        for (int i=0;i<strs.length;i++) {
            String s = strs[i];
            if (j >= s.length()) {
                return false;
            }
            if (s.charAt(j) == c) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //String [] strs = new String[]{"flower","flow","flight"};
        String [] strs = new String[]{"dog","racecar","car"};
        String str = longestCommonPrefix(strs);
        System.out.println("str="+str);
    }
}
