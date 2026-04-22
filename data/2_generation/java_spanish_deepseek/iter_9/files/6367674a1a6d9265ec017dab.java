import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {

    /**
     * Compara dos valores de punto flotante. Devuelve 0 si son iguales, -1 si {@literal o1 < o2},1 en caso contrario.
     * @param o1 el primer valor
     * @param o2 el segundo valor
     * @return 0 si son iguales, -1 si {@literal o1 < o2},1 en caso contrario
     */
    @Override
    public int compare(Double o1, Double o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        } else if (o1.equals(o2)) {
            return 0;
        } else if (o1 < o2) {
            return -1;
        } else {
            return 1;
        }
    }
}