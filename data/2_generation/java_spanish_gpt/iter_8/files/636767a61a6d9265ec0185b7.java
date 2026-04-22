public class DigitValueInterpreter {

    /** 
     * Interpreta un carácter como un dígito (en cualquier base hasta 36) y devuelve el valor numérico. Esto es similar a {@code Character.digit()} pero no aceptamos dígitos no ASCII.
     */
    private static int valorDígito(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0'; // Valores del 0 al 9
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10; // Valores del 10 al 35
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10; // Valores del 10 al 35 (minúsculas)
        } else {
            return -1; // Carácter no válido
        }
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(valorDígito('0')); // 0
        System.out.println(valorDígito('9')); // 9
        System.out.println(valorDígito('A')); // 10
        System.out.println(valorDígito('Z')); // 35
        System.out.println(valorDígito('a')); // 10
        System.out.println(valorDígito('z')); // 35
        System.out.println(valorDígito('@')); // -1
    }
}