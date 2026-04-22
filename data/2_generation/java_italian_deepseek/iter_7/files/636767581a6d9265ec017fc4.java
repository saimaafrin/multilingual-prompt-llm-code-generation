public class FactorialCalculator {

    /**
     * Calcola il fattoriale di $n$.
     * @param n il numero di input
     * @return il fattoriale
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Il fattoriale non è definito per numeri negativi.");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 5; // Esempio di input
        System.out.println("Il fattoriale di " + number + " è " + factorial(number));
    }
}