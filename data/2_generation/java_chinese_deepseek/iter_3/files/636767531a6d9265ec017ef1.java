import java.awt.geom.Point2D;

public class PointComparison {
    private static final double TOLERANCE = 1e-9;

    /**
     * 使用容差 1e-9 比较两个点是否相等。
     * @param p1 第一个点
     * @param p2 第二个点
     * @return 两个点是否相等
     */
    public static boolean equals(Point2D p1, Point2D p2) {
        if (p1 == null || p2 == null) {
            return p1 == p2;
        }
        return Math.abs(p1.getX() - p2.getX()) < TOLERANCE &&
               Math.abs(p1.getY() - p2.getY()) < TOLERANCE;
    }
}