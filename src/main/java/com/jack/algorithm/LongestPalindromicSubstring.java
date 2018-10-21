package com.jack.algorithm;

/**
 * create by jack 2018/10/20
 *
 * @auther jack
 * @date: 2018/10/20 19:22
 * @Description:
 */
public class LongestPalindromicSubstring {

    /**
     * 题目描述：
     * https://leetcode.com/problems/longest-palindromic-substring/
     *
     * 对于n长的字符串他可以分割的点为2n - 1。因为如果是奇数位子串，则它的分割点为中间的字符，如果是偶数位子串，则
     它的分割点为中间点。所以expandAroundCenter(s, i, i)就是奇数位子串的测试，从中心点逐渐向两边延伸
     而expandAroundCenter(s, i, i+1)就是偶数位子串的测试。
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            //奇数位子串的测试
            int len1 = expandAroundCenter(s, i, i);
            //偶数位子串的测试
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }


    /**
     * 从中心往两边扩展
     * 返回值值是回文串的长度
     * @param s
     * @param start
     * @param end
     * @return
     */
    private static int expandAroundCenter(String s, int start, int end){
        int L = start, R = end;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }




    public static void main(String[] args) {

        String s = "a";
        String str = longestPalindrome(s);
        System.out.println("str="+str);


    }
}
