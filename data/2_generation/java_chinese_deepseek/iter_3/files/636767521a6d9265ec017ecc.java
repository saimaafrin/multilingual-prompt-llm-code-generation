import org.apache.commons.math3.geometry.euclidean.twod.Box2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.Pair;

public class BoxSplitter {

    /**
     * 沿 x 轴将一个矩形框拆分为两个相等的矩形框。
     * @param box 要拆分的矩形框
     * @return 包含两个拆分后矩形框的对
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        Vector2D min = box.getMin();
        Vector2D max = box.getMax();

        double midX = (min.getX() + max.getX()) / 2.0;

        Box2D leftBox = new Box2D(min, new Vector2D(midX, max.getY()));
        Box2D rightBox = new Box2D(new Vector2D(midX, min.getY()), max);

        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        Box2D box = new Box2D(new Vector2D(0, 0), new Vector2D(10, 5));
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);

        System.out.println("Left Box: " + splitBoxes.getFirst());
        System.out.println("Right Box: " + splitBoxes.getSecond());
    }
}