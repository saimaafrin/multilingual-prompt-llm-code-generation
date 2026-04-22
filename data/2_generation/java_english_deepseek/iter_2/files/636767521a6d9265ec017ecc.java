import java.awt.geom.Rectangle2D;
import javafx.util.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double x = box.getX();
        double y = box.getY();
        double width = box.getWidth();
        double height = box.getHeight();

        // Calculate the midpoint along the x-axis
        double midX = x + width / 2.0;

        // Create the left box
        Box2D leftBox = new Box2D(x, y, midX - x, height);

        // Create the right box
        Box2D rightBox = new Box2D(midX, y, width / 2.0, height);

        return new Pair<>(leftBox, rightBox);
    }

    public static class Box2D {
        private double x;
        private double y;
        private double width;
        private double height;

        public Box2D(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }
    }

    public static void main(String[] args) {
        Box2D box = new Box2D(0, 0, 10, 5);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);

        System.out.println("Left Box: (" + splitBoxes.getKey().getX() + ", " + splitBoxes.getKey().getY() + 
                          ", " + splitBoxes.getKey().getWidth() + ", " + splitBoxes.getKey().getHeight() + ")");
        System.out.println("Right Box: (" + splitBoxes.getValue().getX() + ", " + splitBoxes.getValue().getY() + 
                          ", " + splitBoxes.getValue().getWidth() + ", " + splitBoxes.getValue().getHeight() + ")");
    }
}