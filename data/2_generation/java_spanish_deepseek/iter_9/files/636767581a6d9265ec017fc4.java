public class FactorialCalculator {

    /**
     * Calcular el factorial de $n$.
     * @param n el número de entrada
     * @return el factorial
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5; // Ejemplo de entrada
        System.out.println("El factorial de " + n + " es: " + factorial(n));
    }
}