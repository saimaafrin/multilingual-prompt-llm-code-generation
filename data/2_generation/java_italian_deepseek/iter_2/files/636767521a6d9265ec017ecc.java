import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class Box2D {
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

public class BoxSplitter {

    /**
     * Divide una "Box2D" lungo l'asse x in due "Box2D" uguali.
     * @param box la scatola da dividere
     * @return una coppia con le due scatole risultanti
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double halfWidth = box.getWidth() / 2.0;

        Box2D leftBox = new Box2D(box.getX(), box.getY(), halfWidth, box.getHeight());
        Box2D rightBox = new Box2D(box.getX() + halfWidth, box.getY(), halfWidth, box.getHeight());

        return new ImmutablePair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        Box2D box = new Box2D(0, 0, 10, 5);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);

        System.out.println("Left Box: (" + splitBoxes.getLeft().getX() + ", " + splitBoxes.getLeft().getY() + 
                           ", " + splitBoxes.getLeft().getWidth() + ", " + splitBoxes.getLeft().getHeight() + ")");
        System.out.println("Right Box: (" + splitBoxes.getRight().getX() + ", " + splitBoxes.getRight().getY() + 
                           ", " + splitBoxes.getRight().getWidth() + ", " + splitBoxes.getRight().getHeight() + ")");
    }
}