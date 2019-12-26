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
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Map<Character, Integer>> mapRows = new ArrayList<>();
        List<Map<Character, Integer>> mapCols = new ArrayList<>();
        List<Map<Character, Integer>> mapBoxes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            mapRows.add(new HashMap<>());
            mapCols.add(new HashMap<>());
            mapBoxes.add(new HashMap<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];

                if (c == '.') {
                    continue;
                }

                Map<Character, Integer> map = mapRows.get(i);
                int value = map.getOrDefault(c, 0);
                if (value != 0) {
                    System.out.println(i + ", " + j);
                    return false;
                }
                map.put(c, 1);

                map = mapCols.get(j);
                value = map.getOrDefault(c, 0);
                if (value != 0) {
                    System.out.println(i + ", " + j);
                    return false;
                }
                map.put(c, 1);

                map = mapBoxes.get((i / 3) * 3 + (j / 3));
                value = map.getOrDefault(c, 0);
                if (value != 0) {
                    System.out.println(i + ", " + j);
                    return false;
                }
                map.put(c, 1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
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
