import org.apache.commons.math3.geometry.euclidean.twod.Box2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.Pair;

public class BoxSplitter {

    /**
     * Divide una caja a lo largo del eje x en dos cajas iguales.
     * @param box la caja a dividir
     * @return un par con las dos cajas resultantes
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        Vector2D min = box.getBarycenter().subtract(new Vector2D(box.getWidth() / 4, 0));
        Vector2D max = box.getBarycenter().add(new Vector2D(box.getWidth() / 4, 0));

        Box2D leftBox = new Box2D(box.getMin(), new Vector2D(max.getX(), box.getMax().getY()));
        Box2D rightBox = new Box2D(new Vector2D(min.getX(), box.getMin().getY()), box.getMax());

        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Box2D box = new Box2D(new Vector2D(0, 0), new Vector2D(10, 10));
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);
        System.out.println("Caja izquierda: " + splitBoxes.getFirst());
        System.out.println("Caja derecha: " + splitBoxes.getSecond());
    }
}