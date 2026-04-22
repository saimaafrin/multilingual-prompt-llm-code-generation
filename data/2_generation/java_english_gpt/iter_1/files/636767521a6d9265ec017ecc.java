import javafx.util.Pair;

class Box2D {
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

    @Override
    public String toString() {
        return "Box2D{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}

public class BoxSplitter {
    /** 
     * Split a box along the x axis into two equal boxes.
     * @param box the box to split
     * @return a pair with the two resulting boxes
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double newWidth = box.getWidth() / 2;
        Box2D box1 = new Box2D(box.getX(), box.getY(), newWidth, box.getHeight());
        Box2D box2 = new Box2D(box.getX() + newWidth, box.getY(), newWidth, box.getHeight());
        return new Pair<>(box1, box2);
    }

    public static void main(String[] args) {
        Box2D originalBox = new Box2D(0, 0, 4, 2);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(originalBox);
        System.out.println("Original Box: " + originalBox);
        System.out.println("Split Boxes: " + splitBoxes.getKey() + ", " + splitBoxes.getValue());
    }
}