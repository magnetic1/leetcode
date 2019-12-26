/**
 * Leetcode - valid_sudoku
 */
package com.leetcode.valid_sudoku;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] loads = new int[3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                int value = c - '0';
                int t = 1 << value;

                int row = loads[0][i];
                if ((row & t) != 0) {
//                    System.out.println(0 + ": " + i + ", " + j);
                    return false;
                }
                loads[0][i] += t;

                int col = loads[1][j];
                if ((col & t) != 0) {
//                    System.out.println(value);
//                    System.out.println(t);
//                    System.out.println(1 + ": " + i + ", " + j);
                    return false;
                }
                loads[1][j] += t;

                int box = loads[2][(i / 3) * 3 + (j / 3)];
                if ((box & t) != 0) {
//                    System.out.println(2 + ": " + i + ", " + j);
                    return false;
                }
                loads[2][(i / 3) * 3 + (j / 3)] += t;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        System.out.println(solution.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }

}
