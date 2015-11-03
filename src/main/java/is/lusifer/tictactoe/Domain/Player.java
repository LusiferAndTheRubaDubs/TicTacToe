package is.lusifer.tictactoe.Domain;

public class Player {
    protected String name;
    protected Boolean isHuman;
    
	public Player(String name) {
        this.name = name;
        this.isHuman = true;
    }
	
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