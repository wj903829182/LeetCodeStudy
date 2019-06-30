package com.jack.algorithm;

/**
 * create by jack 2019/6/30
 *
 * @author jack
 * @date: 2019/6/30 16:19
 * @Description:
 * 递归计算，输入n，按规则计算n-1的序列
 */
public class CountAndSay {

    /**
     * 38-题目描述
     * https://leetcode.com/problems/count-and-say/
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) {
            //递归分解，n=n-1序列，n-1=n-2序列
            s=say(s);
        }
        return s;
    }

    public static String say(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int count = 1;
            while( i+1<s.length() && s.charAt(i) == s.charAt(i+1)) {
                i++;
                //相同字符的个数
                count++;
            }
            sb.append(count);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = countAndSay(10);
        System.out.println("s="+s);
    }
}
