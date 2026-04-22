import org.apache.commons.math3.geometry.euclidean.twod.Box2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.lang3.tuple.Pair;

public class Box2DUtils {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        Vector2D min = box.getMin();
        Vector2D max = box.getMax();

        double midX = (min.getX() + max.getX()) / 2.0;

        Box2D leftBox = new Box2D(min, new Vector2D(midX, max.getY()));
        Box2D rightBox = new Box2D(new Vector2D(midX, min.getY()), max);

        return Pair.of(leftBox, rightBox);
    }
}