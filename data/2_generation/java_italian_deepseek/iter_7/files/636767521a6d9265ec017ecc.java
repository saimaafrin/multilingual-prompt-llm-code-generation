import org.apache.commons.math3.geometry.euclidean.twod.Box2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.Pair;

public class BoxSplitter {

    /**
     * Divide una "Box2D" lungo l'asse x in due "Box2D" uguali.
     * @param box la scatola da dividere
     * @return una coppia con le due scatole risultanti
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        Vector2D min = box.getMin();
        Vector2D max = box.getMax();

        double midX = (min.getX() + max.getX()) / 2.0;

        Box2D leftBox = new Box2D(min, new Vector2D(midX, max.getY()));
        Box2D rightBox = new Box2D(new Vector2D(midX, min.getY()), max);

        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        Box2D box = new Box2D(new Vector2D(0, 0), new Vector2D(10, 10));
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);

        System.out.println("Left Box: " + splitBoxes.getFirst());
        System.out.println("Right Box: " + splitBoxes.getSecond());
    }
}