import java.awt.geom.Rectangle2D;
import javafx.util.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double x = box.getX();
        double y = box.getY();
        double width = box.getWidth();
        double height = box.getHeight();

        // Dividir la caja a lo largo del eje x
        double halfWidth = width / 2.0;

        Box2D leftBox = new Box2D.Double(x, y, halfWidth, height);
        Box2D rightBox = new Box2D.Double(x + halfWidth, y, halfWidth, height);

        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        Box2D box = new Box2D.Double(0, 0, 100, 50);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);

        System.out.println("Left Box: " + splitBoxes.getKey());
        System.out.println("Right Box: " + splitBoxes.getValue());
    }
}

class Box2D extends Rectangle2D.Double {
    public Box2D(double x, double y, double width, double height) {
        super(x, y, width, height);
    }
}