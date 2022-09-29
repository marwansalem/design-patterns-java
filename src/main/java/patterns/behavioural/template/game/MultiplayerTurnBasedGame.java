package patterns.behavioural.template.game;

public abstract class MultiplayerTurnBasedGame {
    protected Player currentPlayer;
    protected final int numberOfPlayers;

    protected MultiplayerTurnBasedGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void run() {
        start();
        while(!haveWinner()) {
            takeTurn();
        }
        System.out.println("Player " + getWinningPlayer() + " wins");
    }

    public abstract Player getWinningPlayer();
    protected abstract void takeTurn();
    protected abstract boolean haveWinner();
    protected abstract void start();
}
