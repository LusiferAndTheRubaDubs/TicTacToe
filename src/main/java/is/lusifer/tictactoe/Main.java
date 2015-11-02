package is.lusifer.tictactoe;


import static spark.Spark.*;

import is.lusifer.tictactoe.GUI.Console;
import is.lusifer.tictactoe.GUI.GUI;


public class Main {

    public static void main(String[] args) {
        GUI gameGUI = new Console(); // nota dependency injection
        gameGUI.run();
    }
}


