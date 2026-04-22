import java.util.Objects;

public class BoxSplitter {

    public static class Box2D {
        private final double minX;
        private final double maxX; 
        private final double minY;
        private final double maxY;

        public Box2D(double minX, double maxX, double minY, double maxY) {
            this.minX = minX;
            this.maxX = maxX;
            this.minY = minY;
            this.maxY = maxY;
        }
    }

    public static class Pair<T,U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }

    /** 
     * Divide una caja a lo largo del eje x en dos cajas iguales.
     * @param box la caja a dividir
     * @return un par con las dos cajas resultantes
     */
    public static Pair<Box2D,Box2D> splitAlongXAxis(Box2D box) {
        Objects.requireNonNull(box, "Box cannot be null");

        double midX = (box.minX + box.maxX) / 2.0;

        Box2D leftBox = new Box2D(box.minX, midX, box.minY, box.maxY);
        Box2D rightBox = new Box2D(midX, box.maxX, box.minY, box.maxY);

        return new Pair<>(leftBox, rightBox);
    }
}