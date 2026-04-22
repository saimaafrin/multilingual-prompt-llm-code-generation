public class LogCalculator {
    /**
     * Calcula el piso($\log_2 (n)$) $+ 1$
     * @param n el número del cual se calculará el logaritmo
     * @return el resultado de floor(log2(n)) + 1
     */
    public static int calculateLogPlusOne(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El número debe ser mayor que 0");
        }
        return (int) (Math.floor(Math.log(n) / Math.log(2))) + 1;
    }

    public static void main(String[] args) {
        int n = 16; // Ejemplo de uso
        int result = calculateLogPlusOne(n);
        System.out.println("El resultado de floor(log2(" + n + ")) + 1 es: " + result);
    }
}