// Abstract class representing a game
public abstract class Game{
    protected String GameName;
    protected int round;


    public Game(String GameName, int round) {
        this.GameName = GameName;
        this.round = round;
    }

    public abstract void start(); // Abstract method to start the game
}
