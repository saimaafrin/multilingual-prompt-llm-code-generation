import java.awt.geom.Point2D;

public class PointComparator {
    /**
     * Compare two points for equality using tolerance 1e-9.
     * @param p1 the first point
     * @param p2 the second point
     * @return whether the two points are equal or not
     */
    public static boolean equals(Point2D p1, Point2D p2) {
        double tolerance = 1e-9;
        return Math.abs(p1.getX() - p2.getX()) < tolerance && 
               Math.abs(p1.getY() - p2.getY()) < tolerance;
    }
}