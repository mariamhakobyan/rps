package de.ebay.rps.command;

import de.ebay.rps.model.GameShape;

/**
 * This class represents command entered by human actor,
 * that indicates which game shape was thrown by human.
 * Possible shape values are:
 * 1. Rock
 * 2. Paper
 * 3. Scissors
 *
 * @see GameShape
 *
 * @author Mariam Hakobyan
 */
public class ThrowShapeCommand extends Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid() {
        String input = getInput();
        if(input.length() != 1) {
            return false;
        }

        if(!Character.isDigit(input.charAt(0))) {
            return false;
        }
        return GameShape.fromString(input) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return "Please throw a shape: [1 = Rock, 2 = Paper, 3 = Scissors]";
    }

    /**
     * {@inheritDoc}
     */
    public GameShape getSelection() {
        return GameShape.fromString(getInput());
    }
}