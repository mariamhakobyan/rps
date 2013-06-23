package de.ebay.rps;

/**
 * Main class which starts the game.
 *
 * @author Mariam Hakobyan
 */
public class Main {

    public static void main(String[] args) {
        GameController gameController =
                new GameController.Builder().
                        setComparator(new GameShapeComparator()).
                        setCommandFactory(new CommandFactory()).
                        setPlayerFactory(new PlayerFactory()).
                        setConsole(new GameConsole()).
                        build();

        gameController.startGame();
    }

}
