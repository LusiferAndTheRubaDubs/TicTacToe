package is.lusifer.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import is.lusifer.tictactoe.Domain.Player;

public class PlayerTests {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("Tests.PlayerTests");
    }

    @Test
    public void testCreation() {
        Player player = new Player();
        assertEquals("Anonymous", player.getName());
        assertEquals(true, player.getIsHuman());
    }

    @Test
    public void testSetType() {
        Player player = new Player();
        player.setIsHuman(false);
        assertEquals(false, player.getIsHuman());
    }

    @Test
    public void testChangeName() {
        Player player = new Player();
        player.setName("Sigmund Freud");
        assertEquals("Sigmund Freud", player.getName());
    }
}
