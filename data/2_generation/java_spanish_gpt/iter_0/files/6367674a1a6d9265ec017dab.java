public class FloatComparator {

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
        }
        if (o1 == null) {
            return -1; // null is considered less than any non-null value
        }
        if (o2 == null) {
            return 1; // any non-null value is considered greater than null
        }
        return Double.compare(o1, o2);
    }
}