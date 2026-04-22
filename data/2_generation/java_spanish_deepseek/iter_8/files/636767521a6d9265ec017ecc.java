import java.awt.geom.Rectangle2D;
import javafx.util.Pair;

public class BoxSplitter {

    /**
     * Divide una caja a lo largo del eje x en dos cajas iguales.
     * @param box la caja a dividir
     * @return un par con las dos cajas resultantes
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double width = box.getWidth();
        double height = box.getHeight();
        double x = box.getX();
        double y = box.getY();

        // Crear la primera caja (mitad izquierda)
        Box2D leftBox = new Box2D(x, y, width / 2, height);

        // Crear la segunda caja (mitad derecha)
        Box2D rightBox = new Box2D(x + width / 2, y, width / 2, height);

        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Box2D originalBox = new Box2D(0, 0, 100, 50);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(originalBox);

        System.out.println("Caja izquierda: " + splitBoxes.getKey());
        System.out.println("Caja derecha: " + splitBoxes.getValue());
    }
}

class Box2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public Box2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Box2D{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}