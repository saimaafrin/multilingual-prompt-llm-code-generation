public class DigitValueInterpreter {

    /** 
     * Interpreta un carattere come una cifra (in qualsiasi base fino a 36) e restituisce il valore numerico. Questo è simile a {@code Character.digit()} ma non accettiamo cifre non-ASCII.
     */
    private static int digitValue(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0'; // Valore per le cifre da 0 a 9
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10; // Valore per le lettere da A a Z
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10; // Valore per le lettere da a a z
        } else {
            return -1; // Restituisce -1 per caratteri non validi
        }
    }

    public static void main(String[] args) {
        // Test del metodo digitValue
        System.out.println(digitValue('0')); // Output: 0
        System.out.println(digitValue('9')); // Output: 9
        System.out.println(digitValue('A')); // Output: 10
        System.out.println(digitValue('Z')); // Output: 35
        System.out.println(digitValue('a')); // Output: 10
        System.out.println(digitValue('z')); // Output: 35
        System.out.println(digitValue('@')); // Output: -1
    }
}