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

        double epsilon = 0.000001; // Tolleranza per confronto di numeri in virgola mobile
        double diff = o1 - o2;

        if (Math.abs(diff) < epsilon) {
            return 0; // I numeri sono considerati uguali
        } else if (diff < 0) {
            return -1; // o1 < o2
        } else {
            return 1; // o1 > o2
        }
    }
}