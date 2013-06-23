package de.ebay.rps.command;

import de.ebay.rps.model.Selectable;

/**
 * This class represents commands entered by human actor.
 *
 * @author Mariam Hakobyan
 */
public abstract class Command {

    private String input;

    /**
     * Gets human inserted input.
     *
     * @return      human input
     */
    public String getInput() {
        return input;
    }

    /**
     * Sets human inserted input.
     *
     * @param input     human input
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * Returns boolean property, which indicates whether the human input is valid.
     *
     * @return  boolean property indicating the validity of human input
     */
    public abstract boolean isValid();

    /**
     * Returns the message, which should be shown to human, based on his input.
     *
     * @return  message shown to human
     */
    public abstract String getMessage();

    /**
     * Returns the {@link Selectable} object instance, which was selected by the human.
     *
     * @return  {@link Selectable} selected by human
     */
    public abstract Selectable getSelection();
}
