package com.leetcode.sudoku_solver;

public class Solution3 {
    int rowmasks[] = new int[9];
    int colmasks[] = new int[9];
    int boxmasks[][] = new int[3][3];
    int moves[] = new int[9 * 9];
    int undolevel = 0;

    void analyze(char[][] board) {
        for (int i = 0; i < 9; i++) {
            rowmasks[i] = colmasks[i] = boxmasks[i / 3][i % 3] = 0x1ff;
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch != '.') {
                    mask(r, c, ch);
                }
            }
        }
    }

    void mask(int row, int col, int bit) {
        int notbit = ~bit;
        rowmasks[row] &= notbit;
        colmasks[col] &= notbit;
        boxmasks[row / 3][col / 3] &= notbit;
    }

    void mask(int row, int col, char ch) {
        mask(row, col, 1 << (ch - '1'));
    }

    void claim(char board[][], int row, int col, int bit) {
        mask(row, col, bit);
        char ch = '1';
        while ((bit >>= 1) != 0) {
            ch++;
        }
        board[row][col] = ch;
        moves[undolevel++] = row * 9 + col;
    }

    void undo(char[][] board, int prevlevel) {
        while (undolevel > prevlevel) {
            int index = moves[--undolevel];
            int row = index / 9;
            int col = index - row * 9;
            int bit = 1 << (board[row][col] - '1');
            board[row][col] = '.';
            rowmasks[row] |= bit;
            colmasks[col] |= bit;
            boxmasks[row / 3][col / 3] |= bit;
        }
    }

    public void solveSudoku(char[][] board) {
        analyze(board);
        trySolve(board, 0, 0);
    }

    boolean trySolve(char[][] board, int row, int nextcol) {
        while (true) {
            boolean foundone = false;
            int col = nextcol;
            for (int r = row; r < 9; r++) {
                for (int c = col; c < 9; c++) {
                    if (board[r][c] == '.') {
                        // 可能的bit值
                        int possbits = rowmasks[r] & colmasks[c] & boxmasks[r / 3][c / 3];
                        if (possbits == 0) {
                            return false;
                        }
                        // 如果possbits只有1位是1，则rembits == 0
                        int rembits = possbits & (possbits - 1);
                        if (rembits == 0) {
                            claim(board, r, c, possbits);
                            foundone = true;
                        }
                    }
                }
                col = 0;
            }
            if (foundone) continue;
            col = nextcol;
            for (int r = row; r < 9; r++) {
                for (int c = col; c < 9; c++) {
                    if (board[r][c] == '.') {
                        int possbits = rowmasks[r] & colmasks[c] & boxmasks[r / 3][c / 3];
                        while (possbits != 0) {
                            // 只去掉最后一位1
                            int rembits = possbits & (possbits - 1);
                            int bit = possbits - rembits;
                            possbits = rembits;
                            int prevundo = undolevel;
                            claim(board, r, c, bit);
                            if (trySolve(board, row, col + 1)) {
                                return true;
                            }
                            undo(board, prevundo);
                        }
                        return false;
                    }
                }
                col = 0;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        char[][] chars = new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        solution.solveSudoku(chars);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(chars[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
