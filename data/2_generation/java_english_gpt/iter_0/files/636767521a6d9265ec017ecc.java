import javafx.util.Pair;

class Box2D {
    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;

    public Box2D(double xMin, double xMax, double yMin, double yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    public double getXMin() {
        return xMin;
    }

    public double getXMax() {
        return xMax;
    }

    public double getYMin() {
        return yMin;
    }

    public double getYMax() {
        return yMax;
    }
}

public class BoxSplitter {
    /** 
     * Split a box along the x axis into two equal boxes.
     * @param box the box to split
     * @return a pair with the two resulting boxes
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double midX = (box.getXMin() + box.getXMax()) / 2;
        Box2D box1 = new Box2D(box.getXMin(), midX, box.getYMin(), box.getYMax());
        Box2D box2 = new Box2D(midX, box.getXMax(), box.getYMin(), box.getYMax());
        return new Pair<>(box1, box2);
    }
}