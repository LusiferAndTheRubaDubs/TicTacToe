package is.lusifer.tictactoe;

import org.junit.Test;

import is.lusifer.tictactoe.Domain.Player;
import is.lusifer.tictactoe.Logic.InvalidMoveException;
import is.lusifer.tictactoe.Logic.State;
import is.lusifer.tictactoe.Logic.TicTacToeGame;

import static org.junit.Assert.assertEquals;

public class GameTests {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("Tests.GameTests");
    }

    @Test
    public void testGameInitialization() {
        TicTacToeGame game = new TicTacToeGame(new Player(), new Player());
        assertEquals(State.RUNNING, game.getGameState());
        assertEquals(null, game.getWinner());
    }

    @Test
    public void testValidMoveOutOfBounds() {
        TicTacToeGame game = new TicTacToeGame(new Player(), new Player());
        try {
            game.makeMove(-1);
        } catch (InvalidMoveException e) {
            assertEquals(e.getClass(), InvalidMoveException.class);
        }
        try {
            game.makeMove(9);
        } catch (InvalidMoveException e) {
            assertEquals(e.getClass(), InvalidMoveException.class);
        }
    }

    @Test
    public void testValidMoveCellTaken() {
        TicTacToeGame game = new TicTacToeGame(new Player(), new Player());
        try {
            game.makeMove(1);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        try {
            game.makeMove(1);
        } catch (InvalidMoveException e) {
            assertEquals(e.getClass(), InvalidMoveException.class);
        }
    }

    @Test
    public void testSwitchCurrentPlayer() {
        TicTacToeGame game = new TicTacToeGame(new Player(), new Player());
        try {
            game.makeMove(1);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        char[] arr = game.getGameBoard();
        assertEquals(arr[1], 'X');

        try {
            game.makeMove(2);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        char[] arr2 = game.getGameBoard();
        assertEquals(arr2[2], 'O');

        try {
            game.makeMove(0);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        char[] arr3 = game.getGameBoard();
        assertEquals(arr2[0], 'X');
    }

    @Test
    public void testCheckWinnerRow() {
        TicTacToeGame game = new TicTacToeGame(new Player(), new Player());
        try {
            game.makeMove(0);
            game.makeMove(2);
            game.makeMove(3);
            game.makeMove(5);
            game.makeMove(6);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(State.WINNER, game.getGameState());
    }

    @Test
    public void testCheckWinnerColumn() {
        TicTacToeGame game = new TicTacToeGame(new Player(), new Player());
        try {
            game.makeMove(0);
            game.makeMove(6);
            game.makeMove(1);
            game.makeMove(5);
            game.makeMove(2);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(State.WINNER, game.getGameState());
    }
    @Test
    public void testCheckWinnerCross() {
        TicTacToeGame game = new TicTacToeGame(new Player(), new Player());
        try {
            game.makeMove(0);
            game.makeMove(3);
            game.makeMove(4);
            game.makeMove(5);
            game.makeMove(8);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(State.WINNER, game.getGameState());

        TicTacToeGame game2 = new TicTacToeGame(new Player(), new Player());
        try {
            game2.makeMove(2);
            game2.makeMove(1);
            game2.makeMove(4);
            game2.makeMove(5);
            game2.makeMove(6);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(State.WINNER, game2.getGameState());
    }

    @Test
    public void testGetWinner() {
        Player X = new Player();
        Player O = new Player();
        TicTacToeGame game = new TicTacToeGame(X, O);
        try {
            game.makeMove(0);
            game.makeMove(2);
            game.makeMove(3);
            game.makeMove(5);
            game.makeMove(6);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(X, game.getWinner());

        TicTacToeGame game2 = new TicTacToeGame(X, O);
        try {
            game2.makeMove(1);
            game2.makeMove(0);
            game2.makeMove(2);
            game2.makeMove(3);
            game2.makeMove(5);
            game2.makeMove(6);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(O, game2.getWinner());
    }
}