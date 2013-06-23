package de.ebay.rps;

import de.ebay.rps.command.Command;
import de.ebay.rps.command.ContinueGameCommand;
import de.ebay.rps.command.SelectGameModeCommand;
import de.ebay.rps.command.ThrowShapeCommand;

/**
 * This class is responsible for creating Command object instances.
 * Possible commands by human are: {@link ContinueGameCommand}, {@link SelectGameModeCommand}, {@link ThrowShapeCommand}
 *
 * @see de.ebay.rps.command.Command
 * @see de.ebay.rps.command.ContinueGameCommand
 * @see de.ebay.rps.command.SelectGameModeCommand
 * @see de.ebay.rps.command.ThrowShapeCommand
 *
 * @author Mariam Hakobyan
 */
public class CommandFactory {

    /**
     * Creates {@link de.ebay.rps.command.ContinueGameCommand} object instance.
     *
     * @return  {@link de.ebay.rps.command.ContinueGameCommand} object instance
     */
    public Command createContinueGameCommand() {
        return new ContinueGameCommand();
    }

    /**
     * Creates {@link de.ebay.rps.command.SelectGameModeCommand} object instance.
     *
     * @return  {@link de.ebay.rps.command.SelectGameModeCommand} object instance
     */
    public Command createSelectGameModeCommand() {
        return new SelectGameModeCommand();
    }

    /**
     * Creates {@link de.ebay.rps.command.ThrowShapeCommand} object instance.
     *
     * @return  {@link de.ebay.rps.command.ThrowShapeCommand} object instance
     */
    public Command createThrowShapeCommand() {
        return new ThrowShapeCommand();
    }
}
