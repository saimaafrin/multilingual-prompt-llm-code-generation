import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.util.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double minX = box.getMinX();
        double minY = box.getMinY();
        double width = box.getWidth();
        double height = box.getHeight();

        // Split the box along the X-axis
        double halfWidth = width / 2;

        Box2D leftBox = new Box2D(minX, minY, halfWidth, height);
        Box2D rightBox = new Box2D(minX + halfWidth, minY, halfWidth, height);

        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        Box2D originalBox = new Box2D(0, 0, 10, 5);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(originalBox);

        System.out.println("Left Box: " + splitBoxes.getKey());
        System.out.println("Right Box: " + splitBoxes.getValue());
    }
}

class Box2D {
    private double minX;
    private double minY;
    private double width;
    private double height;

    public Box2D(double minX, double minY, double width, double height) {
        this.minX = minX;
        this.minY = minY;
        this.width = width;
        this.height = height;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Box2D{" +
                "minX=" + minX +
                ", minY=" + minY +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}