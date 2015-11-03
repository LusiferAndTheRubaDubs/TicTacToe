package is.lusifer.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
import is.lusifer.tictactoe.Logic.TicTacToeGame;
import is.lusifer.tictactoe.Domain.Player;
import is.lusifer.tictactoe.Domain.AI;
import is.lusifer.tictactoe.Logic.InvalidMoveException;
import com.google.gson.Gson;
import is.lusifer.tictactoe.Logic.State;

public class WebUI implements SparkApplication{
	final TicTacToeGame game = new TicTacToeGame(new Player(), new AI());
    public static void main(String[] args) {
        staticFileLocation("/public");
        SparkApplication tttWeb = new WebUI();

        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }

        tttWeb.init();
    }

    @Override
    public void init() {
        
		post("/playerMove", (req, res) -> {
			if(game.getCurrentPlayer().getIsHuman()) {
				try {
					game.makeMove(Integer.parseInt(req.queryParams("tile")) - 1);
				}catch(InvalidMoveException e) {
					res.status(500);
					return res;
				}
			}
			if(game.getGameState() != State.RUNNING) {
				return gameStateJSON();
			}
			game.computerMove();
			if(game.getGameState() != State.RUNNING) {
				return gameStateJSON();
			}
			
			return gameStateJSON();
        });
    }
	private String gameStateJSON() {
		Gson gson = new Gson();
		GameStateJSON state = new GameStateJSON();
		state.board = game.getGameBoard();
		Player winner = game.getWinner();
		if(winner == null)
			state.winnerName = null;
		else
			state.winnerName = winner.getName();
		state.state = game.getGameState();
		
        return gson.toJson(state);
	}
	
	private static class GameStateJSON {
		char[] board;
		String winnerName;
		State state;
	}
}