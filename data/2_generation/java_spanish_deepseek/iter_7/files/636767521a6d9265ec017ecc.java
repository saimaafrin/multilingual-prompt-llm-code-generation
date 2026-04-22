import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.util.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double minX = box.getMinX();
        double minY = box.getMinY();
        double maxX = box.getMaxX();
        double maxY = box.getMaxY();
        double width = maxX - minX;
        double height = maxY - minY;

        // Calculate the midpoint along the X-axis
        double midX = minX + width / 2.0;

        // Create the left box
        Box2D leftBox = new Box2D(minX, minY, midX, maxY);

        // Create the right box
        Box2D rightBox = new Box2D(midX, minY, maxX, maxY);

        return new Pair<>(leftBox, rightBox);
    }

    public static class Box2D {
        private double minX;
        private double minY;
        private double maxX;
        private double maxY;

        public Box2D(double minX, double minY, double maxX, double maxY) {
            this.minX = minX;
            this.minY = minY;
            this.maxX = maxX;
            this.maxY = maxY;
        }

        public double getMinX() {
            return minX;
        }

        public double getMinY() {
            return minY;
        }

        public double getMaxX() {
            return maxX;
        }

        public double getMaxY() {
            return maxY;
        }
    }

    public static void main(String[] args) {
        Box2D box = new Box2D(0, 0, 10, 5);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);
        System.out.println("Left Box: (" + splitBoxes.getKey().getMinX() + ", " + splitBoxes.getKey().getMinY() + ") to (" + splitBoxes.getKey().getMaxX() + ", " + splitBoxes.getKey().getMaxY() + ")");
        System.out.println("Right Box: (" + splitBoxes.getValue().getMinX() + ", " + splitBoxes.getValue().getMinY() + ") to (" + splitBoxes.getValue().getMaxX() + ", " + splitBoxes.getValue().getMaxY() + ")");
    }
}