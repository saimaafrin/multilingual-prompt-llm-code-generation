import java.awt.geom.Point2D;

public class PointComparator {
    /**
     * Compara dos puntos para verificar su igualdad utilizando una tolerancia de 1e-9.
     * @param p1 el primer punto
     * @param p2 el segundo punto
     * @return si los dos puntos son iguales o no
     */
    public static boolean equals(Point2D p1, Point2D p2) {
        if (p1 == null || p2 == null) {
            return false;
        }
        
        double tolerance = 1e-9;
        double xDiff = Math.abs(p1.getX() - p2.getX());
        double yDiff = Math.abs(p1.getY() - p2.getY());
        
        return xDiff <= tolerance && yDiff <= tolerance;
    }
}