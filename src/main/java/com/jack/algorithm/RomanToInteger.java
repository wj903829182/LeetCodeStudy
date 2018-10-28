package com.jack.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * create by jack 2018/10/27
 *
 * @author jack
 * @date: 2018/10/27 08:20
 * @Description:
 * 罗马数字转换为整数
 */
public class RomanToInteger {

    /**
     * 题目描述：
     * https://leetcode.com/problems/roman-to-integer/
     *
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        //为空则直接返回0
        if (s.isEmpty()) {
            return 0;
        }
        int length = s.length();
        int sum = 0;
        Map<Character, Integer> charIntMap = getCharInt();
        //如果为1，则直接获取
        if (length == 1) {
            sum += charIntMap.get(s.charAt(0));
        }
        //如果大于1，长度为2以上
        if (length > 1) {
            //4 or 9
            if (s.charAt(0) == 'I'&& (s.charAt(1) == 'V' ||s.charAt(1) == 'X')) {
                sum += charIntMap.get(s.charAt(1)) - charIntMap.get(s.charAt(0));
                if (length > 2) {
                    sum +=romanToInt(s.substring(2));
                }
                //40 or 90
            } else if (s.charAt(0) == 'X' &&(s.charAt(1) == 'L' ||s.charAt(1) == 'C')) {
                sum += charIntMap.get(s.charAt(1)) - charIntMap.get(s.charAt(0));
                if (length > 2) {
                    sum +=romanToInt(s.substring(2));
                }
                //400 or 900
            }else if (s.charAt(0) == 'C' &&(s.charAt(1) == 'D' ||s.charAt(1) == 'M')) {
                sum += charIntMap.get(s.charAt(1)) - charIntMap.get(s.charAt(0));
                if (length > 2) {
                    sum +=romanToInt(s.substring(2));
                }
            } else {
                sum += charIntMap.get(s.charAt(0));
                sum += romanToInt(s.substring(1));
            }
        }
        return sum;
    }

    public static Map<Character, Integer> getCharInt(){
        Map<Character, Integer> intCharMap = new HashMap<Character, Integer>(16);
        intCharMap.put('I', 1);
        intCharMap.put('V', 5);
        intCharMap.put('X', 10);
        intCharMap.put('L', 50);
        intCharMap.put('C', 100);
        intCharMap.put('D', 500);
        intCharMap.put('M', 1000);
        return intCharMap;
    }

    public static void main(String[] args) {
        //int sum = romanToInt("III");
        //int sum = romanToInt("IV");
        //int sum = romanToInt("IX");
        //int sum = romanToInt("LVIII");
        int sum = romanToInt("DCXXI");
        System.out.println("sum="+sum);
    }
}
