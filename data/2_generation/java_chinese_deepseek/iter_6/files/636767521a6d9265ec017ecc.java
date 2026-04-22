import org.apache.commons.math3.geometry.euclidean.twod.Box2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        // 获取矩形的左下角和右上角坐标
        Vector2D lowerLeft = box.getLowerLeft();
        Vector2D upperRight = box.getUpperRight();

        // 计算矩形的宽度
        double width = upperRight.getX() - lowerLeft.getX();

        // 计算拆分点的x坐标
        double splitX = lowerLeft.getX() + width / 2.0;

        // 创建第一个矩形框（左半部分）
        Box2D leftBox = new Box2D(lowerLeft, new Vector2D(splitX, upperRight.getY()));

        // 创建第二个矩形框（右半部分）
        Box2D rightBox = new Box2D(new Vector2D(splitX, lowerLeft.getY()), upperRight);

        // 返回包含两个矩形框的对
        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        // 示例用法
        Box2D originalBox = new Box2D(new Vector2D(0, 0), new Vector2D(10, 5));
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(originalBox);

        System.out.println("Left Box: " + splitBoxes.getFirst());
        System.out.println("Right Box: " + splitBoxes.getSecond());
    }
}