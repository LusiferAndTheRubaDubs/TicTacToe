package is.lusifer.tictactoe.Domain;

import java.util.Random;

public class AI extends Player {
    public AI() {
        name = "Computer";
        isHuman = false;
    }
    @Override
    public int generateMove() {
        Random rand = new Random();
        int choice = rand.nextInt(9 - 0);
        return choice;
    }
}
