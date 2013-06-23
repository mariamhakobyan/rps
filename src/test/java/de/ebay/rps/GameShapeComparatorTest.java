package de.ebay.rps;

import de.ebay.rps.model.GameShape;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Unit test class to test {@link GameShapeComparator} class methods.
 *
 * @author Mariam Hakobyan
 */
public class GameShapeComparatorTest {

    private static GameShapeComparator gameShapeComparator;

    @BeforeClass
    public static void setUpClass() {
        gameShapeComparator = new GameShapeComparator();
    }

    @Test
    public void testCompareRockAndPaper() {
        assertThat(gameShapeComparator.compare(GameShape.ROCK, GameShape.PAPER), is(-1));
        assertThat(gameShapeComparator.compare(GameShape.PAPER, GameShape.ROCK), is(1));
    }

    @Test
    public void testCompareRockAndScissors() {
        assertThat(gameShapeComparator.compare(GameShape.ROCK, GameShape.SCISSORS), is(1));
        assertThat(gameShapeComparator.compare(GameShape.SCISSORS, GameShape.ROCK), is(-1));
    }

    @Test
    public void testComparePaperAndScissors() {
        assertThat(gameShapeComparator.compare(GameShape.PAPER, GameShape.SCISSORS), is(-1));
        assertThat(gameShapeComparator.compare(GameShape.SCISSORS, GameShape.PAPER), is(1));
    }

    @Test
    public void testCompareSameShapes() {
        assertThat(gameShapeComparator.compare(GameShape.ROCK, GameShape.ROCK), is(0));
        assertThat(gameShapeComparator.compare(GameShape.PAPER, GameShape.PAPER), is(0));
        assertThat(gameShapeComparator.compare(GameShape.SCISSORS, GameShape.SCISSORS), is(0));
    }
}
