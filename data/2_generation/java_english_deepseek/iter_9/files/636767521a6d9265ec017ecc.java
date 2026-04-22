import java.awt.geom.Rectangle2D;
import javafx.util.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double x = box.getX();
        double y = box.getY();
        double width = box.getWidth();
        double height = box.getHeight();

        // Calculate the midpoint along the x-axis
        double midX = x + width / 2;

        // Create the left box
        Box2D leftBox = new Box2D.Double(x, y, width / 2, height);

        // Create the right box
        Box2D rightBox = new Box2D.Double(midX, y, width / 2, height);

        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        Box2D box = new Box2D.Double(0, 0, 10, 5);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);
        System.out.println("Left Box: " + splitBoxes.getKey());
        System.out.println("Right Box: " + splitBoxes.getValue());
    }
}