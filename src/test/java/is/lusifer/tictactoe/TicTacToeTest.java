package is.lusifer.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest {

    @Test 
    public void canYouEnterTheSameTileTwice() {
        TicTacToeBoard ttt = new TicTacToeBoard();
        ttt.insert(1,1);
        assertEquals(false, ttt.insert(1,1));
    }

    @Test 
    public void testingSame() {
        TicTacToeBoard ttt = new TicTacToeBoard();
        ttt.insert(0,1);
        ttt.insert(1,1);
        ttt.insert(2,1);
        ttt.insert(3,2);
        ttt.insert(4,2);
        ttt.insert(5,2);
        assertEquals(true, ttt.same(0,1,2));
        assertEquals(true, ttt.same(3,4,5));
        assertEquals(false, ttt.same(1,4,7));
        assertEquals(false, ttt.same(2,5,8));
    }

    public void winningConditions() {
        TicTacToeBoard ttt = new TicTacToeBoard();
        ttt.insert(0,1);
        ttt.insert(1,1);
        ttt.insert(2,1);
        assertEquals(true, ttt.someoneWon());
        ttt = new TicTacToeBoard();
        ttt.insert(0,1);
        ttt.insert(1,2);
        ttt.insert(2,1);
        assertEquals(false, ttt.someoneWon());
    }
}