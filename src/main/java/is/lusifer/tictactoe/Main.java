package is.lusifer.tictactoe;

public class Main {

    public static void main(String[] args) {
        GUI gameGUI = new Console(); // nota dependency injection
        gameGUI.run();
    }
}


