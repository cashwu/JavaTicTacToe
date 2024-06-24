package com.cashwu;

public class TicTacToe {

    private final char[][] board =
            {{'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}};

    private static void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("axis is outside board");
        }
    }

    public void play(int x, int y) {

        checkAxis(y);
        checkAxis(x);
        setBox(x, y);
    }

    private void setBox(int x, int y) {
        if (board[x-1][y-1] != '\0') {
           throw new RuntimeException("box is occupied");
        }

        board[x-1][y-1] = 'x';
    }
}
