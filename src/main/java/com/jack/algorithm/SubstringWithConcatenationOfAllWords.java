package com.jack.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by jack 2018/11/6
 *
 * @author jack
 * @date: 2018/11/6 22:11
 * @Description:
 */
public class SubstringWithConcatenationOfAllWords {

    /**
     * 题目描述：
     * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
     *
     * @param s
     * @param words
     * @return
     */

    public static List<Integer> findSubstring(String s, String[] words){
        List<Integer> indexes = new ArrayList<>();
        //字符串s和单词数组的边界词判断，符合条件直接返回
        if (words == null || s == null || words.length == 0) {
            return indexes;
        }
        //记录单词出现次数的集合
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            //getOrDefault方法如果存在这个key，则返回value，否则返回默认值
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        //n表示字符串s的长度，num表示单词数组的长度，len表示每个单词的长度
        final int n = s.length(), num = words.length, len = words[0].length();
        //i表示循环次数，最外层循环的次数
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                //截取字符串s的子串
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                //判断截取的子串是否在单词数组中，如果存在，则进入if判断里面，否则结束循环
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    //如果单词不够，说明不能完全匹配，结束循环
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    //不包含直接结束
                    break;
                }
                j++;
            }
            //如果所有的单词都在s串中，则记录这个下标
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }


    public static void main(String[] args) {
        //String s = "barfoothefoobarman";
        //String s = "wordgoodgoodgoodbestword";
        String s = "aaa";

        //String[] words = {"foo","bar"};
        //String[] words = {"word","good","best","word"};
        String[] words = {"a","a"};
        //String[] words = {"1","2","3","4"};
        //System.out.println(JSONObject.toJSONString(words));
        //displayAllStr(words, 0, 3);
        List<Integer> rs = findSubstring(s,words);
        System.out.println("结果为："+JSONObject.toJSONString(rs));
    }
}