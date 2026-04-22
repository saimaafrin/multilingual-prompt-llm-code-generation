public class LogCalculator {
    /**
     * Calcula el piso(log_2(n)) + 1
     * @param n numero entero positivo
     * @return piso(log_2(n)) + 1
     */
    public static int log(int n) {
        int count = 0;
        while (n > 1) {
            n = n/2;
            count++;
        }
        return count + 1;
    }
}