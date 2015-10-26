package is.lusifer.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void greetingsAreMade() {
        Greetings ttt = new Greetings();
        assertEquals("Welcome to a game of Tic-Tac-Toe", ttt.greet());
    }
}
