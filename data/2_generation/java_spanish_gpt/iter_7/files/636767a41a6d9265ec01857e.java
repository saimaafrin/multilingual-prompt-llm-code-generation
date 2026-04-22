public class LongComparator {

    /** 
     * Compara los dos valores {@code long} especificados. El signo del valor devuelto es el mismo que el de {@code ((Long) a).compareTo(b)}. <p> <b>Nota para Java 7 y versiones posteriores:</b> este método debe ser tratado como obsoleto; utiliza el método equivalente {@link Long#compare} en su lugar.
     * @param a el primer {@code long} a comparar
     * @param b el segundo {@code long} a comparar
     * @return un valor negativo si {@code a} es menor que {@code b}; un valor positivo si {@code a} es mayor que {@code b}; o cero si son iguales
     */
    private static int compareSigned(long a, long b) {
        return (a < b) ? -1 : (a > b) ? 1 : 0;
    }

    public static void main(String[] args) {
        long value1 = 10L;
        long value2 = 20L;
        System.out.println(compareSigned(value1, value2)); // Output: -1
        System.out.println(compareSigned(value2, value1)); // Output: 1
        System.out.println(compareSigned(value1, value1)); // Output: 0
    }
}