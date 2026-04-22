import java.awt.geom.Point2D;

public class PointComparison {

    /** 
     * Confronta due punti per uguaglianza utilizzando una tolleranza di 1e-9.
     * @param p1 il primo punto
     * @param p2 il secondo punto
     * @return se i due punti sono uguali o meno
     */
    public static boolean equals(Point2D p1, Point2D p2) {
        if (p1 == null || p2 == null) {
            return false;
        }
        double tolerance = 1e-9;
        return Math.abs(p1.getX() - p2.getX()) < tolerance && Math.abs(p1.getY() - p2.getY()) < tolerance;
    }

    public static void main(String[] args) {
        Point2D point1 = new Point2D.Double(1.0, 2.0);
        Point2D point2 = new Point2D.Double(1.0 + 1e-10, 2.0);
        Point2D point3 = new Point2D.Double(1.0, 2.0 + 1e-10);
        Point2D point4 = new Point2D.Double(1.0, 2.0);

        System.out.println(equals(point1, point2)); // true
        System.out.println(equals(point1, point3)); // true
        System.out.println(equals(point1, point4)); // true
        System.out.println(equals(point1, null));    // false
    }
}