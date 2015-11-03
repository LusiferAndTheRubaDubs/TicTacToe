package is.lusifer.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
import is.lusifer.tictactoe.Logic.TicTacToeGame;
import is.lusifer.tictactoe.Domain.Player;
import is.lusifer.tictactoe.Logic.InvalidMoveException;
import com.google.gson.Gson;

public class WebUI implements SparkApplication{
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
        final TicTacToeGame game = new TicTacToeGame(new Player(), new Player());    
		post("/playerMove", (req, res) -> {
			System.out.println(req);
			try {
				game.makeMove(Integer.parseInt(req.queryParams("tile")));  
			}catch(InvalidMoveException e) {
				res.status(500);
				return res;
			}
            return new Gson().toJson(game.getGameBoard());
        });
    }

}