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

        if (isWin(x, y)) {
            return lastPlayer + " is winner";
        }
        if (isDraw()) {
            return "draw" ;
        }

        return "no winner";
    }

    private boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * SIZE;

        var diagonal1 = '\0';
        var diagonal2 = '\0';
        var horizontal = '\0';
        var vertical = '\0';

        for (int i = 0; i < SIZE; i++) {
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];

            horizontal += board[i][y-1];
            vertical += board[x-1][i];
        }

        return diagonal1 == playerTotal
                || diagonal2 == playerTotal
                || horizontal == playerTotal
                || vertical == playerTotal;
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
