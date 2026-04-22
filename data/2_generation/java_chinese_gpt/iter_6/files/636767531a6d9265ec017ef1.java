import java.awt.geom.Point2D;

public class PointComparison {
    /** 
     * 使用容差 1e-9 比较两个点是否相等。
     * @param p1 第一个点
     * @param p2 第二个点
     * @return 两个点是否相等
     */
    public static boolean equals(Point2D p1, Point2D p2) {
        if (p1 == null || p2 == null) {
            return false;
        }
        double tolerance = 1e-9;
        return Math.abs(p1.getX() - p2.getX()) < tolerance && Math.abs(p1.getY() - p2.getY()) < tolerance;
    }
}