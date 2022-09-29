package patterns.behavioural.template.game;

import java.sql.SQLOutput;

public class Chess extends MultiplayerTurnBasedGame {
    protected Chess(int numberOfPlayers) {
        super(numberOfPlayers);
    }
    private Player black;
    private Player white;
    private Player winner = null;
    private int turn = 1;
    private static final int maxTurns = 10;
    private static final int NUM_PLAYERS = 2;
    public Chess(Player black, Player white) {
        super(NUM_PLAYERS);
        this.black = black;
        this.white = white;
        currentPlayer = black;
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public Player getWinningPlayer() {
        return winner;
    }

    @Override
    protected void takeTurn() {
        System.out.println("Turn " + (turn++) + " taken by player " + currentPlayer);
        // switching for next turn
        currentPlayer = currentPlayer == white ? black : white;
        if (haveWinner()) {
            winner = currentPlayer;
        }
    }

    @Override
    protected boolean haveWinner() {
        return turn == maxTurns;
    }

    @Override
    protected void start() {
        System.out.println("Starting a game of chess.");
    }

    public static void main(String[] args) {
        Player mega = new Player("Chess Megamind");
        Player brain = new Player("Big Brain");
        new Chess(mega, brain).run();
    }
}
