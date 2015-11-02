package is.lusifer.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

import is.lusifer.tictactoe.Domain.GameBoard;

public class GameBoardTests {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("Tests.PlayerTests");
    }

    @Test
    public void testBoardCreation() {
        GameBoard board = new GameBoard();
        char emptyTile = ' ';
        for (char tile : board.getBoard()) {
            assertEquals(emptyTile, tile);
        }
    }

    @Test
    public void testMakeMove() {
        GameBoard board = new GameBoard();
        char testChar = 'X';
        board.makeMove(0, testChar);
        char testArr[] = board.getBoard();
        assertEquals(testChar, testArr[0]);
    }

    @Test
    public void testIsBoardFull() {
        GameBoard board = new GameBoard();
        board.makeMove(0, 'X');
        board.makeMove(1, 'X');
        board.makeMove(2, 'X');
        board.makeMove(3, 'X');
        board.makeMove(4, 'X');
        board.makeMove(5, 'X');
        board.makeMove(6, 'X');
        board.makeMove(7, 'X');
        assertEquals(false, board.isBoardFull());
        board.makeMove(8, 'X');
        assertTrue(board.isBoardFull());
    }

    @Test
    public void testIsCellEmpty() {
        GameBoard board = new GameBoard();
        board.makeMove(0, 'X');
        assertEquals(true, board.isCellEmpty(1));
        assertEquals(false, board.isCellEmpty(0));
    }

    @Test
    public void testGetCell() {
        GameBoard board = new GameBoard();
        board.makeMove(0, 'X');
        assertEquals(' ', board.getCell(1));
        assertEquals('X', board.getCell(0));
    }
}
