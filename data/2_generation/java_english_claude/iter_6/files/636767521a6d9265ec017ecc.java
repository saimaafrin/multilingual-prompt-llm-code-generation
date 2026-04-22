import java.util.Objects;

public class BoxSplitter {

    public static class Box2D {
        private final double x;
        private final double y;
        private final double width;
        private final double height;

        public Box2D(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public double getX() { return x; }
        public double getY() { return y; }
        public double getWidth() { return width; }
        public double getHeight() { return height; }
    }

    public static class Pair<T,U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() { return first; }
        public U getSecond() { return second; }
    }

    /** 
     * Split a box along the x axis into two equal boxes.
     * @param box the box to split
     * @return a pair with the two resulting boxes
     */
    public static Pair<Box2D,Box2D> splitAlongXAxis(Box2D box) {
        Objects.requireNonNull(box, "Box cannot be null");

        double halfHeight = box.getHeight() / 2.0;
        
        // Create bottom box
        Box2D bottomBox = new Box2D(
            box.getX(),
            box.getY(),
            box.getWidth(),
            halfHeight
        );

        // Create top box
        Box2D topBox = new Box2D(
            box.getX(),
            box.getY() + halfHeight,
            box.getWidth(),
            halfHeight
        );

        return new Pair<>(bottomBox, topBox);
    }
}