package com.jack.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * create by jack 2018/10/26
 *
 * @author jack
 * @date: 2018/10/26 22:57
 * @Description:
 * 整数转换为罗马数字
 */
public class IntegerToRoman {

    /**
     * 题目描述：
     * https://leetcode.com/problems/integer-to-roman/
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        int[] n = new int[4];
        int x = num;
        int i = 0;
        while (x != 0) {
            n[i] = x%10;
            x = x/10;
            i++;
        }
        StringBuilder rs = new StringBuilder();
        Map<Integer,Character> intCharMap = getIntChar();
        int bit = 1000;
        for (i=3;i>=0;i--) {
            String str = getStr(n[i], bit, intCharMap);
            rs.append(str);
            bit = bit/10;
        }
        return rs.toString();
    }

    public static  String getStr(int i,int bit,Map<Integer,Character> intCharMap) {
        if (i == 0) {
            return "";
        }
        String rs = "";
        int j=0;
        if (i == 4) {
            rs = rs + intCharMap.get(bit) + intCharMap.get(5 * bit);
        } else if (i == 5) {
            rs = rs + intCharMap.get(bit * 5);
        }
        if (i != 4 && i < 5) {
            j=1;
            for (j=1;j<=i && i!=0;j++) {
                rs = rs +intCharMap.get(bit);
            }
        }
        if (i > 5 && i != 9) {
            rs += intCharMap.get(5 * bit);
            j=1;
            for (j=1;j<=i-5 && i!=0;j++) {
                rs += intCharMap.get(bit);
            }
        } else if (i == 9) {
            rs += intCharMap.get(bit);
            rs += intCharMap.get(bit*10);
        }

        return rs;
    }


    public static   Map<Integer,Character> getIntChar(){
        Map<Integer, Character> intCharMap = new HashMap<Integer, Character>(16);
        intCharMap.put(1, 'I');
        intCharMap.put(5, 'V');
        intCharMap.put(10, 'X');
        intCharMap.put(50, 'L');
        intCharMap.put(100, 'C');
        intCharMap.put(500, 'D');
        intCharMap.put(1000, 'M');
        return intCharMap;
    }

    public static void main(String[] args) {
        String roman = intToRoman(58);
        System.out.println("roman ="+roman);
    }
}
