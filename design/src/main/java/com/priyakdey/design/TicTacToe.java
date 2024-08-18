package com.priyakdey.design;

public class TicTacToe {
    // https://leetcode.com/problems/design-tic-tac-toe/description/

    private final int[][] board;
    private final int rows;
    private final int cols;

    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.rows = n;
        this.cols = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkRow(row, player)
                || checkCol(col, player)
                || checkMainDiagonal(row, col, player)
                || checkSecondaryDiagonal(row, col, player)) {
            return player;
        }

        return 0;
    }

    private boolean checkRow(int row, int player) {
        boolean didWin = true;
        for (int col = 0; col < cols; col++) {
            if (board[row][col] != player) {
                didWin = false;
                break;
            }
        }

        return didWin;
    }

    private boolean checkCol(int col, int player) {
        boolean didWin = true;
        for (int row = 0; row < rows; row++) {
            if (board[row][col] != player) {
                didWin = false;
                break;
            }
        }

        return didWin;
    }

    private boolean checkMainDiagonal(int row, int col, int player) {
        if (row != col) return false;

        boolean didWin = true;
        int r = 0, c = 0;
        while (r < rows && c < cols) {
            if (board[r][c] != player) {
                didWin = false;
                break;
            }
            r++;
            c++;
        }

        return didWin;
    }

    private boolean checkSecondaryDiagonal(int row, int col, int player) {
        if (row + col != rows - 1) return false;

        boolean didWin = true;
        int r = rows - 1, c = 0;
        while (r >= 0 && c < cols) {
            if (board[r][c] != player) {
                didWin = false;
                break;
            }
            r--;
            c++;
        }

        return didWin;
    }


    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(2);
        ticTacToe.move(0, 1, 1);
        ticTacToe.move(1, 1, 2);
        ticTacToe.move(1, 0, 1);
    }

}