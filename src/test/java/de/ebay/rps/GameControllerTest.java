package de.ebay.rps;

import de.ebay.rps.command.ContinueGameCommand;
import de.ebay.rps.command.SelectGameModeCommand;
import de.ebay.rps.model.GameMode;
import de.ebay.rps.model.Player;
import de.ebay.rps.model.YesNo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

/**
 * Unit test class to test {@link GameController} class methods.
 *
 * @author Mariam Hakobyan
 */
@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

    private GameController gameController;

    @Mock
    private CommandFactory commandFactory;

    @Mock
    private PlayerFactory playerFactory;

    @Mock
    private GameConsole console;

    @Mock
    private GameShapeComparator gameShapeComparator;

    @Mock
    private Player player1;

    @Mock
    private Player player2;

    @Before
    public void setUp() {
        gameController = new GameController.Builder().
                setComparator(gameShapeComparator).
                setCommandFactory(commandFactory).
                setPlayerFactory(playerFactory).
                setConsole(console).
                build();
    }

    @Test
    public void testInitializeGameMode() {

        SelectGameModeCommand selectGameModeCommand = mock(SelectGameModeCommand.class);
        when(commandFactory.createSelectGameModeCommand()).thenReturn(selectGameModeCommand);
        when(selectGameModeCommand.getSelection()).thenReturn(GameMode.PLAYER_VS_COMPUTER);

        gameController.initializeGameMode();

        verify(console).setExpectedCommand(selectGameModeCommand);
        verify(console).waitForCommand();

        assertThat(gameController.getGameMode(), is(GameMode.PLAYER_VS_COMPUTER));
    }

    @Test
    public void testPlayAgainYes() {
        ContinueGameCommand continueGameCommand = mock(ContinueGameCommand.class);
        when(commandFactory.createContinueGameCommand()).thenReturn(continueGameCommand);
        when(continueGameCommand.getSelection()).thenReturn(YesNo.YES);

        gameController.setGameFinished(true);
        assertThat(gameController.playAgain(), is(true));
    }

    @Test
    public void testPlayAgainNo() {
        ContinueGameCommand continueGameCommand = mock(ContinueGameCommand.class);
        when(commandFactory.createContinueGameCommand()).thenReturn(continueGameCommand);
        when(continueGameCommand.getSelection()).thenReturn(YesNo.NO);

        gameController.setGameFinished(true);
        assertThat(gameController.playAgain(), is(false));
    }

    @Test
    public void testCompareThrownShapes() {
        gameController.setPlayerOne(player1);
        gameController.setPlayerTwo(player2);

        when(gameShapeComparator.compare(player1.getThrownShape(), player2.getThrownShape())).thenReturn(1);

        gameController.compareThrownShapes();
        verify(console).printPlayerOneWinMessage(player1);

        when(gameShapeComparator.compare(player1.getThrownShape(), player2.getThrownShape())).thenReturn(-1);
        gameController.compareThrownShapes();
        verify(console).printPlayerTwoWinMessage();

        when(gameShapeComparator.compare(player1.getThrownShape(), player2.getThrownShape())).thenReturn(0);
        gameController.compareThrownShapes();
        verify(console).printTryAgain();
    }
}