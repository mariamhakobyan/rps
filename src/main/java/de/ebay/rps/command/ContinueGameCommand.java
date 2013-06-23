package de.ebay.rps.command;

import de.ebay.rps.model.YesNo;

/**
 * This class represents command entered by human actor,
 * which indicates whether game should continue or not.
 *
 * @see YesNo
 * @author Mariam Hakobyan
 */
public class ContinueGameCommand extends Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid() {
        return getInput().trim().equalsIgnoreCase("Y") || getInput().trim().equalsIgnoreCase("N");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return "Play again? - Y/N";
    }

    /**
     * {@inheritDoc}
     */
    public YesNo getSelection() {
        return YesNo.fromString(getInput());
    }
}
