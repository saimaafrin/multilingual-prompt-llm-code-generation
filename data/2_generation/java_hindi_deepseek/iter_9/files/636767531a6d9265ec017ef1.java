import java.awt.geom.Point2D;

public class PointComparison {
    private static final double TOLERANCE = 1e-9;

    /**
     * दो बिंदुओं की समानता की तुलना करें, सहिष्णुता 1e-9 का उपयोग करते हुए।
     * @param p1 पहला बिंदु
     * @param p2 दूसरा बिंदु
     * @return क्या दोनों बिंदु समान हैं या नहीं
     */
    public static boolean equals(Point2D p1, Point2D p2) {
        if (p1 == null || p2 == null) {
            return p1 == p2;
        }
        double dx = Math.abs(p1.getX() - p2.getX());
        double dy = Math.abs(p1.getY() - p2.getY());
        return dx <= TOLERANCE && dy <= TOLERANCE;
    }
}