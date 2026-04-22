import java.awt.geom.Point2D;

public class PointComparator {
    /**
     * Compara dos puntos para verificar su igualdad utilizando una tolerancia de 1e-9.
     * @param p1 el primer punto
     * @param p2 el segundo punto
     * @return si los dos puntos son iguales o no
     */
    public static boolean equals(Point2D p1, Point2D p2) {
        double epsilon = 1e-9;
        return Math.abs(p1.getX() - p2.getX()) < epsilon && 
               Math.abs(p1.getY() - p2.getY()) < epsilon;
    }
}