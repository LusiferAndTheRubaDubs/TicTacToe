package is.lusifer.tictactoe;

public class TicTacToeGame {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameBoard gameBoard;
    private State state;
    private Player winner;
	
	private boolean tileStreak(int a, int b, int c) {
        char x = gameBoard.getCell(a);
        char y = gameBoard.getCell(b);
        char z = gameBoard.getCell(c);
        return x != ' ' && x == y && y == z;
    }

    private boolean checkWinContition() {
        return (tileStreak(0,1,2) || tileStreak(3,4,5)
                || tileStreak(6,7,8) || tileStreak(0,3,6)
                || tileStreak(1,4,7) || tileStreak(2,5,8)
                || tileStreak(0,4,8) || tileStreak(2,4,6)
        );
    }
}
