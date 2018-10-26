package com.jack.algorithm;

/**
 * create by jack 2018/10/24
 *
 * @auther jack
 * @date: 2018/10/24 20:30
 * @Description: 规则表达式匹配
 */
public class RegularExpressionMatching {

    /**
     * 题目描述：
     * https://leetcode.com/problems/regular-expression-matching/
     *
     * 代码解释：
     * https://www.cnblogs.com/qiaozhoulin/p/4785077.html
     * https://www.cnblogs.com/grandyang/p/4461713.html
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        //创建二维数组，行数为：s.length() + 1，列数为：p.length() + 1
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //设置最后一行，最后一列的值为true
        dp[s.length()][p.length()] = true;
        //从最后的字符串往前遍历，这样可以解决*匹配0个或者多个字符的问题
        for (int i = s.length(); i >= 0; i--){
            //字符串的模式遍历
            for (int j = p.length() - 1; j >= 0; j--){
                //i小于s的长度，并且s的i位置的字符等于p的j位置的字符，或者p的j位置为“.”，则说明匹配
                boolean first_match = (i < s.length() &&
                        (p.charAt(j) == s.charAt(i) ||
                                p.charAt(j) == '.'));
                if (j + 1 < p.length() && p.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "aab";
        String s3 = "mississippi";
        String s4 = "abcd";
        String s5 = "mississippi";
        String s6 = "ab";
        String s7 = "aaa";
        String s8 = "aaa";
        String s9 = "aaa";
        String s10 = "aaa";

        String p1 = "a";
        String p2 = "c*a*b";
        String p3 = "mis*is*p*.";
        String p4 = "d*";
        String p5 = "mis*is*ip*.";
        String p6 = ".*c";
        String p7 = "aaaa";
        String p8 = "a*a";
        String p9 = "ab*ac*a";
        String p10 = "ab*a";
        //boolean flag = isMatch(s1, p1);
        boolean flag = isMatch(s2, p2);
        //boolean flag = isMatch(s3, p3);
        //boolean flag = isMatch(s4, p4);
        //boolean flag = isMatch(s5, p5);
        //boolean flag = isMatch(s6, p6);
        //boolean flag = isMatch(s7, p7);
        //boolean flag = isMatch(s8, p8);
        //boolean flag = isMatch(s9, p9);
        //boolean flag = isMatch(s10, p10);
        System.out.println("flag=" + flag);
    }
}
