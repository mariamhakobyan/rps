package de.ebay.rps;

import de.ebay.rps.model.ComputerPlayer;
import de.ebay.rps.model.GameMode;
import de.ebay.rps.model.HumanPlayer;
import de.ebay.rps.model.Player;

/**
 * This class is responsible for creating Player object instances.
 * Possible commands by human are: {@link HumanPlayer}, {@link ComputerPlayer}.
 *
 * @see Player
 * @see HumanPlayer
 * @see ComputerPlayer
 *
 * @author Mariam Hakobyan
 */
public class PlayerFactory {

    /**
     * Creates the first player, which can be either human or computer.
     *
     * @param gameMode      game mode selected by human
     * @return              created player based on selected game mode
     */
    public Player createPlayerOne(GameMode gameMode) {
        switch (gameMode) {
            case PLAYER_VS_COMPUTER:
                return new HumanPlayer();
            case COMPUTER_VS_COMPUTER:
                return new ComputerPlayer();
        }
        return null;
    }

    /**
     * Creates the second player, which is always a computer.
     *
     * @return              created player based on selected game mode
     */
    public Player createPlayerTwo() {
        return new ComputerPlayer();
    }
}
