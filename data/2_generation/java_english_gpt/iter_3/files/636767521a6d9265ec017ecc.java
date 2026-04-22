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

    public Box2D getLeftBox() {
        return new Box2D(x, y, width / 2, height);
    }

    public Box2D getRightBox() {
        return new Box2D(x + width / 2, y, width / 2, height);
    }
}

public class BoxSplitter {
    /** 
     * Split a box along the x axis into two equal boxes.
     * @param box the box to split
     * @return a pair with the two resulting boxes
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        Box2D leftBox = box.getLeftBox();
        Box2D rightBox = box.getRightBox();
        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        Box2D box = new Box2D(0, 0, 4, 2);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);
        System.out.println("Left Box: (" + splitBoxes.getKey().getX() + ", " + splitBoxes.getKey().getY() + ", " + splitBoxes.getKey().getWidth() + ", " + splitBoxes.getKey().getHeight() + ")");
        System.out.println("Right Box: (" + splitBoxes.getValue().getX() + ", " + splitBoxes.getValue().getY() + ", " + splitBoxes.getValue().getWidth() + ", " + splitBoxes.getValue().getHeight() + ")");
    }
}