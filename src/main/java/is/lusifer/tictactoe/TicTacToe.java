package is.lusifer.tictactoe;

public class TicTacToe {
   private boolean vsCpu;
   private TicTacToeBoard board;
   
   public TicTacToe () {
   	board = new TicTacToeBoard();
   }

   private boolean gameOver () {
      return board.isBoardFull() || board.someoneWon();
   }
   
   public void playTicTacToe () {
      System.out.println("Welcome to a game of Tic-Tac-Toe");
   	while (!gameOver()) {

   	}
   }
   
   public static void main(String[] args) { 
      TicTacToe newGame = new TicTacToe();
      newGame.playTicTacToe();
   }
}

