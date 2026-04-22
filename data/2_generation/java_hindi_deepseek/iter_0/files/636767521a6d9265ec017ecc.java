import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.util.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double minX = box.getMinX();
        double minY = box.getMinY();
        double width = box.getWidth();
        double height = box.getHeight();

        // Calculate the midpoint along the X-axis
        double midX = minX + width / 2;

        // Create the left box
        Box2D leftBox = new Box2D(minX, minY, midX - minX, height);

        // Create the right box
        Box2D rightBox = new Box2D(midX, minY, width / 2, height);

        return new Pair<>(leftBox, rightBox);
    }

    public static class Box2D {
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
    }

    public static void main(String[] args) {
        Box2D box = new Box2D(0, 0, 10, 5);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);

        System.out.println("Left Box: (" + splitBoxes.getKey().getMinX() + ", " + splitBoxes.getKey().getMinY() + 
                           ", " + splitBoxes.getKey().getWidth() + ", " + splitBoxes.getKey().getHeight() + ")");
        System.out.println("Right Box: (" + splitBoxes.getValue().getMinX() + ", " + splitBoxes.getValue().getMinY() + 
                           ", " + splitBoxes.getValue().getWidth() + ", " + splitBoxes.getValue().getHeight() + ")");
    }
}