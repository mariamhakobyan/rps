package de.ebay.rps.model;

/**
 * This class represents the player, which can be a human or computer player.
 * It uses {@link GameShape} object to represent the shape thrown by the player.
 *
 * @author Mariam Hakobyan
 */
public abstract class Player {
    private GameShape thrownShape;

    /**
     * Sets the game shape thrown by the player.
     *
     * @param thrownShape   game shape thrown by the player
     */
    public void setThrownShape(GameShape thrownShape) {
        this.thrownShape = thrownShape;
    }

    /**
     * Gets the game shape thrown by the player.
     *
     * @return  game shape thrown by the player
     */
    public GameShape getThrownShape() {
        return thrownShape;
    }

}
