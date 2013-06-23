package de.ebay.rps.model;

/**
 * This enum represents possible game modes, which are:
 * 1. Player vs Computer
 * 2. Computer vs Computer
 *
 * @author Mariam Hakobyan
 */
public enum GameMode implements Selectable {

    /* Player vs Computer */
    PLAYER_VS_COMPUTER(1),
    /* Computer vs Computer */
    COMPUTER_VS_COMPUTER(2);

    private int value;

    /**
     * Constructs GameMode enum.
     *
     * @param value     the value of the game mode
     */
    private GameMode(int value) {
        this.value = value;
    }

    /**
     * Returns the corresponding {@link GameMode} instance based on provided human input.
     *
     * @param input     human input in text format
     * @return          corresponding game mode
     */
    public static GameMode fromString(String input){
        for(GameMode mode : values()){
            if(String.valueOf(mode.value).equals(input)){
                return mode;
            }
        }
        return null;
    }
}
