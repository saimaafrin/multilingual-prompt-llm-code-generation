public class LogCalculator {
    /**
     * Calcula el piso(log_2 (n)) + 1
     * @param n Número entero positivo
     * @return Piso de log base 2 de n más 1
     */
    public static int log2Floor(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n debe ser positivo");
        }
        
        int count = 0;
        while (n > 1) {
            n = n >> 1; // Divide by 2 using bit shift
            count++;
        }
        return count + 1;
    }
}