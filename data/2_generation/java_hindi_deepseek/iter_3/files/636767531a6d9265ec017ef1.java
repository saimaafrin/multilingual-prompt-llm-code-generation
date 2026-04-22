import java.awt.geom.Point2D;

public class PointComparison {
    /**
     * दो बिंदुओं की समानता की तुलना करें, सहिष्णुता 1e-9 का उपयोग करते हुए।
     * @param p1 पहला बिंदु
     * @param p2 दूसरा बिंदु
     * @return क्या दोनों बिंदु समान हैं या नहीं
     */
    public static boolean equals(Point2D p1, Point2D p2) {
        double tolerance = 1e-9;
        return Math.abs(p1.getX() - p2.getX()) < tolerance && 
               Math.abs(p1.getY() - p2.getY()) < tolerance;
    }
}