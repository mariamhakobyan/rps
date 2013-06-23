package de.ebay.rps.command;

import de.ebay.rps.model.GameMode;

/**
 * This class represents command entered by human actor,
 * which indicates the selected game mode.
 * Possible values are:
 * 1. Player vs Computer
 * 2. Computer vs Computer
 *
 * @see GameMode
 * @author Mariam Hakobyan
 */
public class SelectGameModeCommand extends Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid() {
        return GameMode.fromString(getInput()) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return "Please select game mode: [1 = Player vs Computer, 2 = Computer vs Computer]";
    }

    /**
     * {@inheritDoc}
     */
    public GameMode getSelection() {
        return GameMode.fromString(getInput());
    }
}