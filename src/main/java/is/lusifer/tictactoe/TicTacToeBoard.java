package is.lusifer.tictactoe;

public class TicTacToeBoard {
	private static final int boardSize = 9;
   private int[] board = new int[boardSize];

   public boolean insert (int tile, int player) {
      if (tile > 9 || tile < 0) {
      	return false;
      }
      if (board[tile] == 0) {
      	board[tile] = player;
      	return true;
      }
      return false;
   }

	public boolean same(int a, int b, int c) { 
		int x = board[a];
		int y = board[b];
		int z = board[c];
		return (x == y && y == z);
	}

   public boolean someoneWon() {
		return (same(0,1,2) || same(3,4,5) || same(6,7,8)
         || same(0,3,6) || same(1,4,7) || same(2,5,8)
         || same(0,4,8) || same(2,4,6)
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

   public String greet() {
      return "Welcome to a game of Tic-Tac-Toe";
   }
}
