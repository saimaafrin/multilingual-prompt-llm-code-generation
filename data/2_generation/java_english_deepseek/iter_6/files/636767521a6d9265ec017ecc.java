import org.apache.commons.geometry.euclidean.twod.Box2D;
import org.apache.commons.geometry.euclidean.twod.Vector2D;
import org.apache.commons.lang3.tuple.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        // Get the min and max points of the box
        Vector2D min = box.getMin();
        Vector2D max = box.getMax();

        // Calculate the midpoint along the x-axis
        double midX = (min.getX() + max.getX()) / 2.0;

        // Create the first box (left half)
        Box2D leftBox = Box2D.from(
            min,
            Vector2D.of(midX, max.getY())
        );

        // Create the second box (right half)
        Box2D rightBox = Box2D.from(
            Vector2D.of(midX, min.getY()),
            max
        );

        // Return the pair of boxes
        return Pair.of(leftBox, rightBox);
    }
}