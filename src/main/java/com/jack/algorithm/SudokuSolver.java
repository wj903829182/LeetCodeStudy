package com.jack.algorithm;

import java.util.HashSet;

/**
 * create by jack 2019/6/30
 *
 * @author jack
 * @date: 2019/6/30 10:14
 * @Description:
 * 使用数字字符1-9填充二维数组
 */
public class SudokuSolver {

    /**
     * 37-题目描述：
     * https://leetcode.com/problems/sudoku-solver/
     *
     * @param board
     */
    public static void solveSudoku(char[][] board) {
        if (solve(board));
    }

    /**
     * 判断某一行是否已经存在字符num，存在返回true，不存在返回false
     * @param board
     * @param row
     * @param num
     * @return
     */
    private static boolean usedRow(char[][] board, int row, char num) {
        //i小于二维数组的列数
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断num这个字符是否在这一列被使用了，被使用了返回true，没被使用返回false
     * @param board
     * @param col
     * @param num
     * @return
     */
    private static boolean usedCol(char[][] board, int col, char num){
        for(int i=0; i<board.length; i++) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断3*3的单元格是否存在字符num，存在返回true，不存在返回false
     * @param board
     * @param rowStart
     * @param colStart
     * @param num
     * @return
     */
    private static boolean usedBox(char[][] board, int rowStart, int colStart, char num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + rowStart][j + colStart] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * row行，collie填充字符num，是否安全
     * @param board
     * @param row
     * @param col
     * @param num
     * @return
     */
    private static boolean isSafe(char[][] board, int row, int col, char num) {
        //row-row%3用的比较巧妙，根据传入的row找到第0,3,6行，这是3*3行的起始行
        //同理col-col%3，根据传入的col找到0,3,6列，这是3*3行的起始列
        //所以根据上面的计算，可以找到所有的3*3的起始单元格
        return !usedRow(board, row, num) && !usedCol(board, col, num) && !usedBox(board, row - row % 3, col - col % 3, num) && board[row][col] == '.';
    }

    /**
     *查找到二维数组中有"."的列，并返回一个数组，数组两个值，第一个值是i表示行，第二个值是j表示列
     * @param board
     * @return
     */
    private static int[] getUnfilledCell(char[][] board) {
        //二维数组行的长度
        for (int i = 0; i < board.length; i++) {
            //二维数组的列数
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 递归调用填充，把“.”填充为字符1-9
     * @param board
     * @return
     */
    private static boolean solve(char[][] board) {
        //获取到没有填充的单元格所在的行和列的数组，如果返回null表示已经填充完成了，直接返回ture
        int[] next = getUnfilledCell(board);
        if (next == null) {
            return true;
        }
        //获取没有填充列的行号，列号
        int row = next[0], col = next[1];
        //从ascill字符遍历字符1-9字符
        for (char i = '1'; i <= '9'; i++) {
            //判断填充字符i(i表示字符1-9)，是否安全，如果安全，则把i赋值给row，col单元格
            if (isSafe(board, row, col, i)) {
                board[row][col] = i;
                //上面赋值了一个元素，继续对第二个"."进行赋值，继续递归调用，如果解决了就返回true，没解决就重新把row，col单元格赋值为"."
                if (solve(board)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
