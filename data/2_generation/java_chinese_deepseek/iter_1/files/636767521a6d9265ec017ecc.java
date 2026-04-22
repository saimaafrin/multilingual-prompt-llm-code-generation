import org.apache.commons.math3.geometry.euclidean.twod.Box2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.lang3.tuple.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        // 获取矩形的左下角和右上角坐标
        Vector2D lowerLeft = box.getLo();
        Vector2D upperRight = box.getHi();

        // 计算矩形的宽度
        double width = upperRight.getX() - lowerLeft.getX();

        // 计算拆分点的x坐标
        double splitX = lowerLeft.getX() + width / 2.0;

        // 创建第一个矩形框
        Box2D firstBox = new Box2D(lowerLeft, new Vector2D(splitX, upperRight.getY()));

        // 创建第二个矩形框
        Box2D secondBox = new Box2D(new Vector2D(splitX, lowerLeft.getY()), upperRight);

        // 返回两个矩形框的对
        return Pair.of(firstBox, secondBox);
    }
}