public class FactorialCalculator {
    
    /** 
     * Calcular el factorial de $n$.
     * @param n el número de entrada
     * @return el factorial
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 5; // Ejemplo de uso
        long fact = factorial(number);
        System.out.println("El factorial de " + number + " es: " + fact);
    }
}