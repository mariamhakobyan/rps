package de.ebay.rps.util;

import java.util.Random;

/**
 * This class is responsible for random number generation based on the given limit value.
 *
 * @author Mariam Hakobyan
 */
public class RandomUtil {

    /**
     * Single instance of random generator object.
     */
    private static Random randomNumberGenerator = new Random();

    /**
     * Constructs a {@link RandomUtil} object.
     */
    private RandomUtil() {
    }

    /**
     * Returns a random number from 1 to limit.
     *
     * @param limit     given limit value
     * @return          random number from specified range
     */
    public static int getRandomNumber(int limit) {
        return 1 + randomNumberGenerator.nextInt(limit);
    }
}
