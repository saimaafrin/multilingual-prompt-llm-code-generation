import java.awt.geom.Point2D;

public class PointComparator {
    private static final double TOLERANCE = 1e-9;

    /**
     * Compare two points for equality using tolerance 1e-9.
     * @param p1 the first point
     * @param p2 the second point
     * @return whether the two points are equal or not
     */
    public static boolean equals(Point2D p1, Point2D p2) {
        if (p1 == null || p2 == null) {
            return p1 == p2;
        }
        double dx = Math.abs(p1.getX() - p2.getX());
        double dy = Math.abs(p1.getY() - p2.getY());
        return dx < TOLERANCE && dy < TOLERANCE;
    }
}