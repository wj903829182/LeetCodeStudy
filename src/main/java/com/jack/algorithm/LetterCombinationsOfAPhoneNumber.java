package com.jack.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * create by jack 2018/10/30
 *
 * @author jack
 * @date: 2018/10/30 21:35
 * @Description:
 * 字符串组合
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * 题目描述：
     * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> rs = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return rs;
        }
        Map<Character, char[]> map = getMap();
        rs = groupStr( rs,digits,map,0);
        return rs;
    }

    public static List<String> groupStr(List<String> rs,String digits,Map<Character, char[]> map,int index) {
        List<String> strList = new ArrayList<>();
        if (rs.isEmpty()) {
            char[] chars = map.get(digits.charAt(index));
            for (int i = 0; i < chars.length; i++) {
                strList.add(String.valueOf(chars[i]));
            }
        } else if (rs.get(0).length() != digits.length()) {
            for (String s : rs) {
                char[] chars = map.get(digits.charAt(index));
                for (int i = 0; i < chars.length; i++) {
                    strList.add(s + chars[i]);
                }
            }
        }
        rs = strList;
        if (rs.get(0).length() == digits.length()) {
            return rs;
        } else {
            return groupStr( rs,digits,map,++index);
        }

    }

    public static Map<Character, char[]> getMap() {
        Map<Character, char[]> map = new HashMap<>(16);
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        return map;
    }

    public static void main(String[] args) {
        String str = "23";
        List<String> list = letterCombinations(str);
        System.out.println("list="+ JSONObject.toJSONString(list));
    }
}
