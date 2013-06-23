package de.ebay.rps;

import de.ebay.rps.command.Command;
import de.ebay.rps.model.HumanPlayer;
import de.ebay.rps.model.Player;

import java.util.Scanner;

/**
 * This class represents the game console, where the player inputs his commands.
 *
 * @see Scanner
 * @see Command
 * @see Player
 *
 * @author Mariam Hakobyan
 */
public class GameConsole {

    /* Scanner instance, from where the human inputs will be retrieved. */
    private Scanner scanner = new Scanner(System.in, "UTF-8");

    /* Expected command from human */
    private Command expectedCommand;

    /**
     * Prints welcome message to the console.
     */
    public void printWelcomeMessage() {
        System.out.println("Welcome to Rock-Paper-Scissors Game!!!");
    }

    /**
     * Prints message to the console about the human input being invalid.
     */
    private void printInvalidInput() {
        System.out.println("Invalid input!");
    }

    /**
     * Prints message to the console, that player one won.
     *
     * @param winnerPlayer      the winner player object instance
     */
    public void printPlayerOneWinMessage(Player winnerPlayer) {
        StringBuilder playerNameStr = new StringBuilder("The winner is player1");
        if(winnerPlayer instanceof HumanPlayer) {
            playerNameStr.append(" (You)");
        }
        System.out.println(playerNameStr);
    }

    /**
     * Prints message to the console, that player two (which is always the computer) won.
     */
    public void printPlayerTwoWinMessage() {
        System.out.println("The winner is player2");
    }

    /**
     * Prints a message asking human to throw another shape to continue the game.
     */
    public void printTryAgain() {
        System.out.println("Please try again...");
    }

    /**
     * Prints messages informing human which player selected which shape.
     *
     * @param playerOne     first player (human or computer)
     * @param playerTwo     second player (computer)
     */
    public void printSelectedShape(Player playerOne, Player playerTwo) {
        StringBuilder playerOneStr = new StringBuilder("Player 1");
        StringBuilder playerTwoStr = new StringBuilder("Player 2");
        StringBuilder selectionStr = new StringBuilder(" selected the following shape: ");
        if (playerOne instanceof HumanPlayer) {
            playerOneStr.append(" (You)");
        }
        System.out.println(playerOneStr.append(selectionStr).append(playerOne.getThrownShape().toString()));
        System.out.println(playerTwoStr.append(selectionStr).append(playerTwo.getThrownShape().toString()));
    }

    /**
     * Prints game end message.
     */
    public void printEndMessage() {
        System.out.println("Bye bye...");
    }

    /**
     * Sets the expected command of the human.
     *
     * @param expectedCommand   the expected command from the human
     */
    public void setExpectedCommand(Command expectedCommand) {
        this.expectedCommand = expectedCommand;
    }

    /**
     * Waits for human to enter the command. Verifies the command, and in case of invalid input
     * prints a message about it.
     */
    public void waitForCommand() {
        System.out.println(expectedCommand.getMessage());

        while (true) {
            System.out.print('>');
            // Gets the next input from human
            String input = scanner.nextLine();
            expectedCommand.setInput(input);

            // Verifies human inserted command
            if (expectedCommand.isValid()) {
                break;
            } else {
                printInvalidInput();
            }
        }
    }
}
