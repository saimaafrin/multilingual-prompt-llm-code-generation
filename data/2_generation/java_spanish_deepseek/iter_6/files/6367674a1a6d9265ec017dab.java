import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {
    @Override
    public int compare(Double o1, Double o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        }

        double epsilon = 1e-10; // Tolerancia para comparación de punto flotante
        double diff = o1 - o2;

        if (Math.abs(diff) < epsilon) {
            return 0; // Son iguales dentro de la tolerancia
        } else if (diff < 0) {
            return -1; // o1 es menor que o2
        } else {
            return 1; // o1 es mayor que o2
        }
    }
}