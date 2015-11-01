package is.lusifer.tictactoe;

public class GameBoard {
    private char board[];
    private int cellsFull;

    public GameBoard() {
        board = new char[9];
        for(int i = 0; i < 9; i++)
            board[i] = ' ';
        cellsFull = 0;
    }

    public char[] getBoard() {
        return board;
    }

    public void makeMove(int tile, char mark) {
        board[tile] = mark;
        cellsFull++;
    }

    public char getCell(int tile) {
        return board[tile];
    }

    public boolean isCellEmpty(int tile) {
        return board[tile] == ' ';
    }

    public boolean isBoardFull() {
        return cellsFull >= 9;
    }
}
