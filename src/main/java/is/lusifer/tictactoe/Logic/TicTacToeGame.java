package is.lusifer.tictactoe.Logic;

import is.lusifer.tictactoe.Domain.GameBoard;
import is.lusifer.tictactoe.Domain.Player;

public class TicTacToeGame {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameBoard gameBoard;
    private State state;
    private Player winner;
	
    public TicTacToeGame(Player player1, Player player2) {
        gameBoard = new GameBoard();
        state = State.RUNNING;
        winner = null;
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    public State getGameState() {
        return state;
    }

    private boolean tileStreak(int a, int b, int c) {
        char x = gameBoard.getCell(a);
        char y = gameBoard.getCell(b);
        char z = gameBoard.getCell(c);
        return x != ' ' && x == y && y == z;
    }

    private boolean checkWin() {
        return (tileStreak(0,1,2) || tileStreak(3,4,5)
                || tileStreak(6,7,8) || tileStreak(0,3,6)
                || tileStreak(1,4,7) || tileStreak(2,5,8)
                || tileStreak(0,4,8) || tileStreak(2,4,6)
        );
    }
    
    public void makeMove(int tile) throws InvalidMoveException {
        if(validMove(tile)) {
            gameBoard.makeMove(tile, getMark());
            if(checkWin()) {
                state = State.WINNER;
                winner = currentPlayer;
                return;
            } else if(gameBoard.isBoardFull()) {
                state = State.TIE;
                return;
            }
            switchCurrentPlayer();
        } else {
            throw new InvalidMoveException();
        }
    }

    private void switchCurrentPlayer() {
        if(currentPlayer == player1)
            currentPlayer = player2;
        else
            currentPlayer = player1;
    }

    private char getMark() {
        return currentPlayer == player1 ? 'X' : 'O';
    }

    private boolean validMove(int tile) {
        if(tile > 8 || tile < 0)
            return false;
        if(!gameBoard.isCellEmpty(tile))
            return false;

        return true;
    }

    public Player getWinner() {
        return winner;
    }

    public char[] getGameBoard() {
        return gameBoard.getBoard();
    }
    
    public Player getCurrentPlayer() { //
        return currentPlayer;
    }

    public void computerMove() {  //
        Player ai = getCurrentPlayer();
        boolean valid;
        do {
            valid = true;
            int choice = ai.generateMove();
            try {
                makeMove(choice);
            }catch (InvalidMoveException e) {
                valid = false;
            }
        }while(!valid);

    }
}