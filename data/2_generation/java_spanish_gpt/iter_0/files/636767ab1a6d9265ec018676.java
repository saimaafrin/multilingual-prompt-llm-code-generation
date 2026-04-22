public class HexDigitChecker {

    /** 
     * ¿Es este un dígito hexadecimal?
     */
    private static boolean esHex(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    public static void main(String[] args) {
        // Pruebas
        System.out.println(esHex('A')); // true
        System.out.println(esHex('g')); // false
        System.out.println(esHex('3')); // true
        System.out.println(esHex('f')); // true
        System.out.println(esHex('Z')); // false
    }
}