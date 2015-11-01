package is.lusifer.tictactoe;

public class Player {
    protected String name;
    protected Boolean isHuman;
    
    public Player() {
        this.name = "Anonymous";
        this.isHuman = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsHuman() {
        return isHuman;
    }

    public void setIsHuman(Boolean isHuman) {
        this.isHuman = isHuman;
    }

    public int generateMove() {
        return -1;
    }
 }