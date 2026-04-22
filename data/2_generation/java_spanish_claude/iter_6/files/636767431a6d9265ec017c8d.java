public class LogCalculator {
    /**
     * Calcula el piso(log_2 (n)) + 1
     * @param n Número entero positivo
     * @return Piso(log_2(n)) + 1
     */
    public static int log2Floor(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n debe ser positivo");
        }
        
        int result = 0;
        while (n > 1) {
            n = n >> 1; // Divide by 2 using bit shift
            result++;
        }
        return result + 1;
    }
}