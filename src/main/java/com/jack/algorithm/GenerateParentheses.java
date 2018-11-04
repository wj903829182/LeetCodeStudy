package com.jack.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * create by jack 2018/11/2
 *
 * @author jack
 * @date: 2018/11/2 23:30
 * @Description:
 * 给n对括号，查找所有正确组合的括号
 */
public class GenerateParentheses {

    /**
     * 题目描述：
     * https://leetcode.com/problems/generate-parentheses/
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);
        System.out.println("list="+ JSONObject.toJSONString(list));
    }
}
