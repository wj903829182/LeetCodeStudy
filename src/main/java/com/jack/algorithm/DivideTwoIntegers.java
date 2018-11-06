package com.jack.algorithm;

/**
 * create by jack 2018/11/5
 *
 * @author jack
 * @date: 2018/11/5 22:25
 * @Description:
 * 不使用除非和乘法求商
 */
public class DivideTwoIntegers {

    /**
     * 题目描述：
     * https://leetcode.com/problems/divide-two-integers/
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) {
            return 0;
        }
        boolean flag = (dividend<0 && divisor>0)||(dividend>0 && divisor<0);
        //注意要转换成long型
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long result = 0;
        if(a<b)
            return 0;
        long sum=0;
        long pow=0;
        while(a>=b){
            sum = b;
            pow = 1;
            while(sum+sum<=a){
                sum+=sum;
                pow+=pow;
            }
            a-=sum;
            result+=pow;
        }
        System.out.println("result="+result);
        if (flag == true) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) result;
        }
    }

    public static void main(String[] args) {
        int rs = divide(10,3);
        //int rs = divide(7,-3);
        //int rs = divide(-2147483648,-1);
        System.out.println("rs = "+rs);
    }
}
