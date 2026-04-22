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
     * Divide una "Box2D" lungo l'asse x in due "Box2D" uguali.
     * @param box la scatola da dividere
     * @return una coppia con le due scatole risultanti
     */
    public static Pair<Box2D,Box2D> splitAlongXAxis(Box2D box) {
        Objects.requireNonNull(box);
        
        double halfWidth = box.getWidth() / 2.0;
        
        Box2D leftBox = new Box2D(
            box.getX(),
            box.getY(),
            halfWidth,
            box.getHeight()
        );
        
        Box2D rightBox = new Box2D(
            box.getX() + halfWidth,
            box.getY(),
            halfWidth,
            box.getHeight()
        );
        
        return new Pair<>(leftBox, rightBox);
    }
}