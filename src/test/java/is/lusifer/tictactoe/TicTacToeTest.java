package is.lusifer.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest {

   @Test
   public void enteringDataIntoBoard() {
      GameBoard ttt = new GameBoard();
      for (int i = 0; i < 9; i++) {
         ttt.set(i,1);
      }

      IllegalArgumentException caughtException = null;
      try {
         ttt.set(-1,1);
      }
      catch(IllegalArgumentException e){
         caughtException = e;
      }
      assertEquals(caughtException.getMessage(), "Input needs to be between 0 and 8");

      caughtException = null;
      try {
         ttt.set(9,1);
      }
      catch(IllegalArgumentException e){
         caughtException = e;
      }
      assertEquals(caughtException.getMessage(), "Input needs to be between 0 and 8");
   }

   @Test 
   public void testingTileStreak() {
      GameBoard ttt = new GameBoard();
      ttt.set(0,1);
      ttt.set(1,1);
      ttt.set(2,1);
      ttt.set(3,2);
      ttt.set(4,2);
      ttt.set(5,2);
      assertEquals(true, ttt.tileStreak(0,1,2));
      assertEquals(true, ttt.tileStreak(3,4,5));
      assertEquals(false, ttt.tileStreak(1,4,7));
      assertEquals(false, ttt.tileStreak(2,5,8));
   }
   
   @Test
   public void gameOverLogicTest() {
      GameBoard ttt = new GameBoard();
      ttt.set(6,1);
      ttt.set(3,2);
      assertEquals(false, ttt.someoneWon());
      ttt.set(0,1);
      ttt.set(4,2);
      assertEquals(false, ttt.someoneWon());
      ttt.set(1,1);
      ttt.set(2,2);
      assertEquals(false, ttt.someoneWon());
      ttt.set(7,1);
      ttt.set(5,2);
      assertEquals(true, ttt.someoneWon());
   }
}