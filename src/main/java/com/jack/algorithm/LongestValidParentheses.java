package com.jack.algorithm;

import java.util.Stack;

/**
 * create by jack 2019/5/4
 *
 * @author jack
 * @date: 2019/5/4 19:44
 * @Description:
 */
public class LongestValidParentheses {
    /**
     * 32-题目描述：
     * https://leetcode.com/problems/longest-valid-parentheses/
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            //如果是左括号，则入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //如果是右括号则出栈
                stack.pop();
                if (stack.empty()) {
                    //如果栈为空了，则记下当前的下标
                    stack.push(i);
                } else {
                    //如果不为空，则获取最大长度
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        //String s = "(()";
        String s = ")()())";
        int rs =longestValidParentheses(s);
        System.out.println("rs="+rs);
    }

}
