package de.ebay.rps.model;

import java.util.Arrays;
import java.util.List;

/**
 * This enum represents possible game shapes that can be thrown by the players.
 * Allowed values are:
 * 1. Rock
 * 2. Paper
 * 3. Scissors
 *
 * @author Mariam Hakobyan
 */
public enum GameShape implements Selectable {

    /* Rock shape */
    ROCK(1, "Rock"),
    /* Paper shape */
    PAPER(2, "Paper"),
    /* Scissors shape */
    SCISSORS(3, "Scissors");

    private int value;
    private String name;
    private List<GameShape> weakShapes;
    private List<GameShape> strongShapes;

    /**
     * Initialization of game shapes and their weak and strong shape options.
     */
    static {
        ROCK.weakShapes = Arrays.asList(SCISSORS);
        ROCK.strongShapes = Arrays.asList(PAPER);

        PAPER.weakShapes = Arrays.asList(ROCK);
        PAPER.strongShapes = Arrays.asList(SCISSORS);

        SCISSORS.weakShapes = Arrays.asList(PAPER);
        SCISSORS.strongShapes = Arrays.asList(ROCK);
    }

    /**
     * Constructs a game shape with specified value and name.
     *
     * @param value     game shape enum value
     * @param name      game shape enum name
     */
    private GameShape(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Returns the corresponding {@link GameShape} instance based on provided human input.
     *
     * @param input     human input in text format
     * @return          corresponding game shape
     */
    public static GameShape fromString(String input) {
        for (GameShape shape : values()) {
            if (String.valueOf(shape.value).equals(input)
                    || shape.name.equalsIgnoreCase(input)) {
                return shape;
            }
        }
        return null;
    }

    /**
     * Returns the corresponding {@link GameShape} instance based on provided human input.
     *
     * @param input     human input in number format
     * @return          corresponding game shape
     */
    public static GameShape fromInt(int input) {
        return fromString(String.valueOf(input));
    }

    /**
     * Returns the list of shapes, which are weaker than the current one.
     *
     * @return  list of weaker shapes
     */
    public List<GameShape> getWeakShapes() {
        return weakShapes;
    }

    /**
     * Returns the list of shapes, which are stronger than the current one.
     *
     * @return  list of stronger shapes
     */
    public List<GameShape> getStrongShapes() {
        return strongShapes;
    }
}
