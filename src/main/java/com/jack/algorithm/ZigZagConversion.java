package com.jack.algorithm;

/**
 * create by jack 2018/10/21
 *
 * @auther jack
 * @date: 2018/10/21 09:05
 * @Description:
 */
public class ZigZagConversion {


    /**
     * 题目描述：
     * https://leetcode.com/problems/zigzag-conversion/
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        int length = s.length();
        //特殊值的处理
        if (length <= numRows || numRows == 0 || numRows == 1) {
            return s;
        }
        //一个周期的锯齿状长度，有规律
        int z = 2*numRows -2;
        //二维数组的列数
        int c = (length/z)*(numRows-1);
        int r = 0;
        if (length % z > 0) {
            r = (length%z)/numRows == 0? 1:(1+(length%z)%numRows);
            c = c+ r;
        }
        //创建二维字符串数组，行为numRows，列为c，初始值为：'\0'
        char[][] chars = new char[numRows][c];
        //char [][] chars = new char[numRows][];
        //把字符串存入二维数组
        //m为商，n为余数
        int m =0,n=0;
        for (int l = 1,i=0,j=0;l<= length;l++) {
            char ch = s.charAt(l-1);
            chars[i][j]=ch;
            m = l / z;
            n = l % z;
            //3,4
            if (n!=0 && n < numRows) {
                i++;
            }
            if (n == numRows) {
                i= i-1;
                j++;
            }
            if (n > numRows || n == 0 ) {
                i--;
                j++;
            }
        }
        String rs = display(chars,numRows,c);
        //输出二维数组
        return rs;

    }

    /**
     * 把字符数组转换为字符串
     * @param chars
     * @param r
     * @param c
     * @return
     */
    public static  String display(char[][] chars,int r,int c){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                //判断是否为默认值，不为默认值的时候才添加字符
                if (chars[i][j] !='\0') {
                    sb.append(chars[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //String s1 = "PAHNAPLSIIGYIR";
        //String s1 = "PAYPALISHIRING";
        //String s1 = "PAYPALISHIRING";
        //String s1 = "AB";
        String s1 = "PAYPALISHIRING";
        //System.out.println("length = "+s1.length());
        String s = convert(s1,3);
        System.out.println("");
        System.out.println("s ="+s);
    }
}
