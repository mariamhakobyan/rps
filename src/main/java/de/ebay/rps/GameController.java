package de.ebay.rps;

import de.ebay.rps.command.*;
import de.ebay.rps.model.*;
import de.ebay.rps.util.RandomUtil;

/**
 * This class is responsible for the main logic of Rock-Paper-Scissors game.
 *
 * @see GameShapeComparator
 * @see CommandFactory
 * @see PlayerFactory
 * @see Player
 * @see GameConsole
 * @see GameMode
 * @see GameShape
 *
 * @author Mariam Hakobyan
 */
public class GameController {

    /* Game shapes comparator */
    private GameShapeComparator comparator;
    /* Command factory which created command objects */
    private CommandFactory commandFactory;
    /* Player factory which created player objects */
    private PlayerFactory playerFactory;
    /* Game console where human inputs are entered */
    private GameConsole console;
    /* Number of possible shapes in the game */
    private int numberOfPossibleShapes;
    /* Game mode which will be selected by human */
    private GameMode gameMode;
    /* First player (human or computer) */
    private Player playerOne;
    /* Second player (computer) */
    private Player playerTwo;
    /* Indicates if the game is finished or not */
    private boolean isGameFinished;

    /**
     * Constructs a game controller object instance, which initializes all the necessary objects
     * in order to start the game.
     *
     * @param builder   builder object to construct the game controller object
     */
    private GameController(Builder builder) {
        comparator = builder.comparator;
        commandFactory = builder.commandFactory;
        playerFactory = builder.playerFactory;
        console = builder.console;
        numberOfPossibleShapes = GameShape.values().length;
    }

    /**
     * Starts the Rock-Paper-Scissors game.
     * After the first round human will be asked to continue the game,
     * and based on provided answer the game can continue.
     */
    public void startGame() {
        console.printWelcomeMessage();

        initializeGameMode();

        initializePlayers();

        while (playAgain()) {
            startRound();
        }
        console.printEndMessage();
    }

    /**
     * Initializes game mode based on the input provided by the human.
     */
    protected void initializeGameMode() {
        Command command = commandFactory.createSelectGameModeCommand();
        console.setExpectedCommand(command);
        console.waitForCommand();
        gameMode = (GameMode) command.getSelection();
    }

    /**
     * Initializes players.
     */
    private void initializePlayers() {
        playerOne = playerFactory.createPlayerOne(gameMode);
        playerTwo = playerFactory.createPlayerTwo();
    }

    /**
     * Starts the game round. Each player throws a shape, the program compares
     * the shapes and based on comparison decides which player won.
     */
    protected void startRound() {
        switch (gameMode) {
            case PLAYER_VS_COMPUTER:
                Command command = commandFactory.createThrowShapeCommand();
                console.setExpectedCommand(command);
                console.waitForCommand();
                playerOne.setThrownShape((GameShape) command.getSelection());
                break;
            case COMPUTER_VS_COMPUTER:
                GameShape shape = GameShape.fromInt(RandomUtil.getRandomNumber(numberOfPossibleShapes));
                playerOne.setThrownShape(shape);
                break;
        }
        GameShape shape = GameShape.fromInt(RandomUtil.getRandomNumber(numberOfPossibleShapes));
        playerTwo.setThrownShape(shape);

        console.printSelectedShape(playerOne, playerTwo);

        compareThrownShapes();
    }

    /**
     * Asks use whether to continue the game and play another round, and
     * based on use input returns boolean property. If the value is true, then
     * the game will be continued, otherwise won't.
     *
     * @return  boolean property which indicated if the game will be continued or not
     */
    protected boolean playAgain() {
        if(isGameFinished) {
            Command command = commandFactory.createContinueGameCommand();
            console.setExpectedCommand(command);
            console.waitForCommand();
            if(command.getSelection() == YesNo.YES) {
                isGameFinished = false;
            }
        }
        return !isGameFinished;
    }

    /**
     * Compares shapes thrown by the players, and based on the comparison decides which player wins.
     * If both players threw the same shape, the program asks to continue the game and
     * thrown new shapes.
     *
     * @see GameShapeComparator
     */
    protected void compareThrownShapes() {

        int compareValue = comparator.compare(playerOne.getThrownShape(), playerTwo.getThrownShape());
        if(compareValue == 1) {
            isGameFinished = true;
            console.printPlayerOneWinMessage(playerOne);
        } else if(compareValue == -1) {
            isGameFinished = true;
            console.printPlayerTwoWinMessage();
        } else {
            console.printTryAgain();
        }
    }

    /**
     * Builder inner class, which is responsible for building a new {@link GameController} object
     * based on specified properties.
     */
    public static class Builder {
        private GameShapeComparator comparator;
        private CommandFactory commandFactory;
        private PlayerFactory playerFactory;
        private GameConsole console;

        /**
         * Sets comparator object.
         *
         * @param comparator    game shape comparator
         * @return              builder instance
         */
        public Builder setComparator(GameShapeComparator comparator) {
            this.comparator = comparator;
            return this;
        }

        /**
         * Sets command factory object.
         *
         * @param commandFactory    command factory
         * @return                  builder instance
         */
        public Builder setCommandFactory(CommandFactory commandFactory) {
            this.commandFactory = commandFactory;
            return this;
        }

        /**
         * Sets player factory object.
         *
         * @param playerFactory     player factory
         * @return                  builder instance
         */
        public Builder setPlayerFactory(PlayerFactory playerFactory) {
            this.playerFactory = playerFactory;
            return this;
        }

        /**
         * Sets game console object.
         *
         * @param console           game console
         * @return                  builder instance
         */
        public Builder setConsole(GameConsole console) {
            this.console = console;
            return this;
        }

        /**
         * Builds a {@link GameController} object based on specified properties.
         *
         * @return      constructed {@link GameController} object
         */
        public GameController build() {
            if(comparator == null || commandFactory == null || playerFactory == null || console == null) {
                throw new IllegalStateException("Comparator, CommandFactory, PlayerFactory and GameConsole are required!");
            }
            return new GameController(this);
        }
    }

    /**
     * Gets the property indicating the game mode.
     *
     * @return  game mode
     */
    public GameMode getGameMode() {
        return gameMode;
    }

    /**
     * Sets the property indicating whether the game finished or not.
     * Is used for test purposes only.
     *
     * @param gameFinished  boolran property whether the game finished or not
     */
    protected void setGameFinished(boolean gameFinished) {
        isGameFinished = gameFinished;
    }

    /**
     * Sets the first player.
     * Is used for test purposes only.
     *
     * @param playerOne     first player
     */
    protected void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    /**
     * Sets the second player.
     * Is used for test purposes only.
     *
     * @param playerTwo second player
     */
    protected void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }
}
