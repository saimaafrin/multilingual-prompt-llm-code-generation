import java.awt.geom.Rectangle2D;
import javafx.util.Pair;

public class BoxSplitter {

    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double x = box.getX();
        double y = box.getY();
        double width = box.getWidth();
        double height = box.getHeight();

        // Calcular la mitad del ancho
        double halfWidth = width / 2.0;

        // Crear la primera caja (izquierda)
        Box2D leftBox = new Box2D.Double(x, y, halfWidth, height);

        // Crear la segunda caja (derecha)
        Box2D rightBox = new Box2D.Double(x + halfWidth, y, halfWidth, height);

        // Retornar el par de cajas
        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Box2D box = new Box2D.Double(0, 0, 100, 50);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);

        System.out.println("Caja izquierda: " + splitBoxes.getKey());
        System.out.println("Caja derecha: " + splitBoxes.getValue());
    }
}