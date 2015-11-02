/*
 * @(#)TicTacToeGame.java        0.5 02/11/15
 *
 * Copyright (c) 2015 Lúsífer and the Rub-a-dub's.
 * 101 Reykjavík Iceland.
 * All rights reserved.
 */

package is.lusifer.tictactoe.Logic;

import is.lusifer.tictactoe.Domain.GameBoard;
import is.lusifer.tictactoe.Domain.Player;

/**
 *  The TicTacToeGame Class handles most of the logic needed for a game of TicTacToe.
 *
 * @version 0.5 2 Nov 2015   
 * @author Lúsífer and the Rub-a-dub's
 */

public class TicTacToeGame {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameBoard gameBoard;
    private State state;
    private Player winner;
	
    /**
     * Initializes a game of TicTacToe
     * @param player1 Will play with 'X'
     * @param player2 Will play with 'O'
     */
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
    
    /**
     * A game of TicTacToe is won when 3 tiles are the same. 
     * tileStreak handles comparing 3 cells but not what cell that is.
     * checkWin() checks for all the possible winning outcomes.
     * @param a tile location 1
     * @param b tile location 2
     * @param c tile location 3
     * @return returns true if all the tiles were the same and not all empty 
     */
    private boolean tileStreak(int a, int b, int c) {
        char x = gameBoard.getCell(a);
        char y = gameBoard.getCell(b);
        char z = gameBoard.getCell(c);
        return x != ' ' && x == y && y == z;
    }
    
    /**
     * Checks all possible winning outcomes
     * @return true if someone has 3 tiles in a row 
     */
    private boolean checkWin() {
        return (tileStreak(0,1,2) || tileStreak(3,4,5)
                || tileStreak(6,7,8) || tileStreak(0,3,6)
                || tileStreak(1,4,7) || tileStreak(2,5,8)
                || tileStreak(0,4,8) || tileStreak(2,4,6)
        );
    }
    
    /**
     * Takes a tile number and places it in the grid. 
     * If a winning move was made, the current player gets the state of a winner
     * If an invalid move is made, an InvalidMoveException() is thrown
     * @param tile tile number 1-9
     * @throws InvalidMoveException
     */
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
    
    /**
     * Switch out who is currently selected as the player
     */
    private void switchCurrentPlayer() {
        if(currentPlayer == player1)
            currentPlayer = player2;
        else
            currentPlayer = player1;
    }

    /**
     * 
     * @return
     */
    private char getMark() {
        return currentPlayer == player1 ? 'X' : 'O';
    }

    /**
     * Checks if the tile number given is awailable
     * @param tile number
     * @return false if the number is not between 1 and 9, false if the board is full, true otherwise
     */
    private boolean validMove(int tile) {
        if(tile > 8 || tile < 0)
            return false;
        if(!gameBoard.isCellEmpty(tile))
            return false;

        return true;
    }

    /**
     * Returns the winner if there is one
     * @return either player1, player2 or null if there is no winner
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * Returns the board
     * @return the board
     */
    public char[] getGameBoard() {
        return gameBoard.getBoard();
    }
    
    /**
     * Returns the current player
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Plays round of the game with an ai
     * @return a valid move 
     */
    public int computerMove() {
        Player ai = getCurrentPlayer();
        boolean valid;
        int choice;
        do {
            valid = true;
            choice = ai.generateMove();
            try {
                makeMove(choice);
            }catch (InvalidMoveException e) {
                valid = false;
            }
        }while(!valid);
        return choice;
    }
}