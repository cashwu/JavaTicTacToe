import com.cashwu.TicTacToe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeSpec {

    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
      }

    @Test
    void whenXOutsideBoardThenRuntimeException() {
        assertThrows(RuntimeException.class,
                () -> ticTacToe.play(5, 2));
      }

    @Test
    void whenYOutsideBoardThenRuntimeException() {
        assertThrows(RuntimeException.class,
                () -> ticTacToe.play(2, 5));
    }

    @Test
    void whenOccupiedThenRuntimeException() {

        ticTacToe.play(2, 1);

        assertThrows(RuntimeException.class,
                () -> ticTacToe.play(2, 1));
    }


    @Test
    void givenFirstTurnWhenNextPlayerThenX() {
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    void givenLastTurnWhenWasXWhenNextPlayerThenO() {
        ticTacToe.play(1, 1);
        assertEquals('O', ticTacToe.nextPlayer());
    }


    @Test
    void whenPlayerThenNoWinner() {
        String actual = ticTacToe.play(1, 1);
        assertEquals("no winner", actual);
    }


    @Test
    void whenPlayAndHoleHorizontalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        String actual = ticTacToe.play(3, 1);// X
        assertEquals("X is winner", actual);
    }


    @Test
    void whenPlayAndVerticalLineThenWinner() {
        ticTacToe.play(2, 1); // X
        ticTacToe.play(1, 1); // O
        ticTacToe.play(3, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        String actual = ticTacToe.play(1, 3);// O
        assertEquals("O is winner", actual);
    }

    @Test
    void whenPlayAndTopBottomDiagonalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(1, 3); // O
        String actual = ticTacToe.play(3, 3);// X
        assertEquals("X is winner", actual);
    }

    @Test
    void whenPlayAndBottomTopDiagonalLineThenWinner() {
        ticTacToe.play(1, 3); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(2, 3); // O
        String actual = ticTacToe.play(3, 1);// X
        assertEquals("X is winner", actual);
    }












}
