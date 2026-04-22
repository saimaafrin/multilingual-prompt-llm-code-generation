import org.apache.commons.geometry.euclidean.twod.Box2D;
import org.apache.commons.geometry.euclidean.twod.Vector2D;
import org.apache.commons.lang3.tuple.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        // 获取矩形的边界
        double minX = box.getMinX();
        double maxX = box.getMaxX();
        double minY = box.getMinY();
        double maxY = box.getMaxY();

        // 计算中间点
        double midX = (minX + maxX) / 2.0;

        // 创建两个新的矩形框
        Box2D leftBox = Box2D.from(minX, minY, midX, maxY);
        Box2D rightBox = Box2D.from(midX, minY, maxX, maxY);

        // 返回拆分后的矩形框对
        return Pair.of(leftBox, rightBox);
    }

    public static void main(String[] args) {
        // 示例用法
        Box2D originalBox = Box2D.from(0, 0, 10, 5);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(originalBox);

        System.out.println("Left Box: " + splitBoxes.getLeft());
        System.out.println("Right Box: " + splitBoxes.getRight());
    }
}