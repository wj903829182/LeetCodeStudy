package com.jack.algorithm;

import java.util.Stack;

/**
 * create by jack 2018/11/1
 *
 * @author jack
 * @date: 2018/11/1 23:01
 * @Description:
 * 括号匹配
 */
public class ValidParentheses {

    /**
     * 题目描述：
     * https://leetcode.com/problems/valid-parentheses/
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int length = s.length();
        Stack<Character> stack = new Stack();
        for (int i=0;i<length;i++) {
            char c1 = s.charAt(i);
            if (c1 == '(' || c1 == '{' || c1 == '[') {
                stack.push(c1);
            } else {
                if (!stack.empty()) {
                    char c2 = stack.pop();
                    if (c1 ==')' && c2 == '(') {
                        continue;
                    }else if(c1 == '}' && c2 == '{'){
                        continue;
                    } else if(c1 == ']' && c2 =='['){
                        continue;
                    }else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //String s = "()";
        //String s = "()[]{}";
        //String s = "(]";
        //String s = "([)]";
        String s = "{[]}";
        boolean flag = isValid(s);
        System.out.println("flag = "+flag);

    }
}
