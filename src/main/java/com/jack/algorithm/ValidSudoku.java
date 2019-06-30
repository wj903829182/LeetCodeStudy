package com.jack.algorithm;

import java.util.HashSet;

/**
 * create by jack 2019/5/4
 *
 * @author jack
 * @date: 2019/5/4 22:09
 * @Description:
 */
public class ValidSudoku {
    /**
     * 36-题目描述：
     * https://leetcode.com/problems/valid-sudoku/
     * 判断输入的二维字符数组是否符合要求：
     *
     *  A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     Only the filled cells need to be validated according to the mentioned rules.
     The given board contain only digits 1-9 and the character '.'.
     The given board size is always 9x9.
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        boolean valid = true;
        // check rows
        for(int r = 0; r < 9; r++)
        {
            valid = valid && isValidRow(board, r);
        }// check columns
        for(int c = 0; c < 9; c++)
        {
            valid = valid && isValidColumn(board, c);
        }
        // check boxes
        for(int r = 0; r < 9; r += 3)
        {
            for(int c = 0; c < 9; c += 3)
            {
                valid = valid && isValidBox(board, r, c);
            }
        }
        // if any of the methods returned false, valid will be false
        // else it will be true
        return valid;
    }


    /**
     * 检查行是否符合要求，每一行是否包含重复出现的数字
     * @param board
     * @param r
     * @return
     */
    public static boolean isValidRow(char[][] board, int r)
    {
        HashSet<Character> set = new HashSet<>();

        for(int a = 0; a < 9; a++)
        {
            char current = board[r][a];
            //如果是点则跳过
            if (current == '.') {
                continue;
            }
            //如果包含返回false
            if(set.contains(current)) {
                return false;
            } else {
                set.add(current);
            }
        }
        return true;
    }


    /**
     * 每一列是否包含相同的数字
     * @param board
     * @param c
     * @return
     */
    public static boolean isValidColumn(char[][] board, int c)
    {
        HashSet<Character> set = new HashSet<>();

        for(int a = 0; a < 9; a++)
        {
            char current = board[a][c];
            //如果是“.”则跳过
            if(current == '.') {
                continue;
            }
            //如果包含返回false
            if(set.contains(current)) {
                return false;
            } else {
                set.add(current);
            }
        }
        return true;
    }

    /**
     * 检查3*3的矩阵是否符合要求
     * @param board
     * @param r
     * @param c
     * @return
     */
    public static boolean isValidBox(char[][] board, int r, int c)
    {
        HashSet<Character> set = new HashSet<>();
        for(int a = r; a < r + 3; a++)
        {
            for(int b = c; b < c + 3; b++)
            {
                char current = board[a][b];
                //是“.”就跳过
                if(current == '.') {
                    continue;
                }
                //包含返回false
                if(set.contains(current)) {
                    return false;
                } else {
                    set.add(current);
                }
            }
        }
        return true;
    }




    public static char[][] getCharArray(String [][] strs) {
        char[][] chars = new char[9][9];
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                chars[i][j] = strs[i][j].charAt(0);
            }
        }
        return chars;

    }

    public static void displayChar(char[][] chars) {
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                System.out.print("'"+chars[i][j]+"'"+",");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        String[][] strs = new String[][]{
                {"8", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };
        char[][] chars = getCharArray(strs);
        //displayChar(chars);
        boolean valid = isValidSudoku(chars);
        System.out.println("valid="+valid);

    }
}
