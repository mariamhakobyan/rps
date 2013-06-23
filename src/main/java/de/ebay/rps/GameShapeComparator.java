package de.ebay.rps;

import de.ebay.rps.model.GameShape;

import java.util.Comparator;

/**
 * This class compares game shapes. The comparison logic between the shapes is the following:
 * 1. Rock wins Scissors
 * 2. Paper wins Rock
 * 3. Scissors win Paper
 *
 * @author Mariam Hakobyan
 */
public class GameShapeComparator implements Comparator<GameShape> {

    /**
     * Compares different game shapes.
     *
     * @param shape1    first shape to compare
     * @param shape2    second shape to compare
     * @return          the comparison results represented as int value
     */
    @Override
    public int compare(GameShape shape1, GameShape shape2) {
        if(shape1.getWeakShapes().contains(shape2)) {
            return 1;
        } else if(shape1.getStrongShapes().contains(shape2)) {
            return -1;
        }
        return 0;
    }
}
