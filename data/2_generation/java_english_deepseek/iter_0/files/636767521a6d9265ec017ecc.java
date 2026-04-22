import org.apache.commons.geometry.euclidean.twod.Box2D;
import org.apache.commons.geometry.euclidean.twod.Vector2D;
import org.apache.commons.lang3.tuple.Pair;

public class BoxSplitter {

    /**
     * Split a box along the x axis into two equal boxes.
     * @param box the box to split
     * @return a pair with the two resulting boxes
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        Vector2D min = box.getMin();
        Vector2D max = box.getMax();

        double midX = (min.getX() + max.getX()) / 2.0;

        Box2D leftBox = Box2D.from(min, Vector2D.of(midX, max.getY()));
        Box2D rightBox = Box2D.from(Vector2D.of(midX, min.getY()), max);

        return Pair.of(leftBox, rightBox);
    }
}