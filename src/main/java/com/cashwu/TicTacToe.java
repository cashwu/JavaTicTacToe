package com.cashwu;

public class TicTacToe {

    private static final int SIZE = 3;
    private final char[][] board =
            {{'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}};
    private char lastPlayer = '\0';

    private static void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("axis is outside board");
        }
    }

    public String play(int x, int y) {

        checkAxis(y);
        checkAxis(x);

        lastPlayer = nextPlayer();

        setBox(x, y);

        if (isWin()) {
            return lastPlayer + " is winner";
        }

        return "no winner";
    }

    private boolean isWin() {
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] == lastPlayer
            && board[1][i] == lastPlayer
            && board[2][i] == lastPlayer) {
               return true;
            }
        }
        return false;
    }

    private void setBox(int x, int y) {
        if (board[x-1][y-1] != '\0') {
           throw new RuntimeException("box is occupied");
        }

        board[x-1][y-1] = lastPlayer;
    }

    public char nextPlayer() {

        if (lastPlayer == 'X') {
           return 'O' ;
        }
        return 'X';
    }
}
