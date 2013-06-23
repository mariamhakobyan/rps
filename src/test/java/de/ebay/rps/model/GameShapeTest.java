package de.ebay.rps.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Unit test class to test {@link GameShape} class methods.
 *
 * @author Mariam Hakobyan
 */
public class GameShapeTest {

    @Test
    public void testFromStringToGameShape() {
        assertThat(GameShape.fromString("1"), is(GameShape.ROCK));
        assertThat(GameShape.fromString("Rock"), is(GameShape.ROCK));

        assertThat(GameShape.fromString("2"), is(GameShape.PAPER));
        assertThat(GameShape.fromString("Paper"), is(GameShape.PAPER));

        assertThat(GameShape.fromString("3"), is(GameShape.SCISSORS));
        assertThat(GameShape.fromString("Scissors"), is(GameShape.SCISSORS));
    }

    @Test
    public void testFromIntToGameShape() {
        assertThat(GameShape.fromInt(1), is(GameShape.ROCK));
        assertThat(GameShape.fromInt(2), is(GameShape.PAPER));
        assertThat(GameShape.fromInt(3), is(GameShape.SCISSORS));
    }
}
