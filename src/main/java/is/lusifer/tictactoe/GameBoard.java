package is.lusifer.tictactoe;

public class GameBoard {
   private static final int boardSize = 9;
   private int[] board = new int[boardSize];

   public void set (int tile, int player) {
      if (tile > 8 || tile < 0) {
         throw new IllegalArgumentException("Input needs to be between 0 and 8");
      }
      board[tile] = player;
   }

   public boolean tileStreak(int a, int b, int c) {
      int x = board[a];
      int y = board[b];
      int z = board[c];
      return x != 0 && x == y && y == z;
   }

   // checks if there is already a winner
   public boolean someoneWon() {
      return (tileStreak(0,1,2) || tileStreak(3,4,5)
         || tileStreak(6,7,8) || tileStreak(0,3,6) 
         || tileStreak(1,4,7) || tileStreak(2,5,8)
         || tileStreak(0,4,8) || tileStreak(2,4,6)
      );
   }

   // checks each tile and looks for one that doesnt have an entry
   public boolean isBoardFull () {
      for (int i = 0; i < boardSize; i++) {
         if (board[i] == 0) {
            return false;
         }
      }
      return true;
   }
}
