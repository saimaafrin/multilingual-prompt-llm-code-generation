import java.awt.geom.Point2D;
import javafx.util.Pair;

public class BoxSplitter {
    
    public static class Box2D {
        private Point2D topLeft;
        private double width;
        private double height;
        
        public Box2D(Point2D topLeft, double width, double height) {
            this.topLeft = topLeft;
            this.width = width;
            this.height = height;
        }
        
        public Point2D getTopLeft() {
            return topLeft;
        }
        
        public double getWidth() {
            return width;
        }
        
        public double getHeight() {
            return height;
        }
    }

    /** 
     * Divide una "Box2D" lungo l'asse x in due "Box2D" uguali.
     * @param box la scatola da dividere
     * @return una coppia con le due scatole risultanti
     */
    public static Pair<Box2D,Box2D> splitAlongXAxis(Box2D box) {
        // Get original box dimensions and position
        Point2D originalTopLeft = box.getTopLeft();
        double originalWidth = box.getWidth();
        double originalHeight = box.getHeight();
        
        // Calculate new width (half of original)
        double newWidth = originalWidth / 2;
        
        // Create left box with same top-left point
        Box2D leftBox = new Box2D(originalTopLeft, newWidth, originalHeight);
        
        // Create right box with shifted top-left point
        Point2D rightBoxTopLeft = new Point2D.Double(
            originalTopLeft.getX() + newWidth,
            originalTopLeft.getY()
        );
        Box2D rightBox = new Box2D(rightBoxTopLeft, newWidth, originalHeight);
        
        return new Pair<>(leftBox, rightBox);
    }
}