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

    public Box2D split(double newX, double newWidth) {
        return new Box2D(newX, this.y, newWidth, this.height);
    }
}

public class BoxSplitter {
    /** 
     * Split a box along the x axis into two equal boxes.
     * @param box the box to split
     * @return a pair with the two resulting boxes
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double halfWidth = box.getWidth() / 2;
        Box2D box1 = box.split(box.getX(), halfWidth);
        Box2D box2 = box.split(box.getX() + halfWidth, halfWidth);
        return new Pair<>(box1, box2);
    }

    public static void main(String[] args) {
        Box2D box = new Box2D(0, 0, 10, 5);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);
        System.out.println("Box 1: (" + splitBoxes.getKey().getX() + ", " + splitBoxes.getKey().getY() + ", " + splitBoxes.getKey().getWidth() + ", " + splitBoxes.getKey().getHeight() + ")");
        System.out.println("Box 2: (" + splitBoxes.getValue().getX() + ", " + splitBoxes.getValue().getY() + ", " + splitBoxes.getValue().getWidth() + ", " + splitBoxes.getValue().getHeight() + ")");
    }
}