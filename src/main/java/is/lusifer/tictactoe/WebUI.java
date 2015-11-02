package is.lusifer.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
import is.lusifer.tictactoe.Logic.TicTacToeGame;
import is.lusifer.tictactoe.Domain.Player;

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
		get("/test", (req, res) -> "Hello World");	
    }

}