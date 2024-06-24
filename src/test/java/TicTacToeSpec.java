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










}
