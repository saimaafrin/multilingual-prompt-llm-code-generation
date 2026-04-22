public class HexConverter {
    /**
     * @param b Un carattere codificato in ASCII da 0-9, a-f, A-F
     * @return Il valore byte del carattere da 0 a 16.
     */
    public static byte convertHexDigit(byte b) {
        if (b >= '0' && b <= '9') {
            return (byte) (b - '0');
        } else if (b >= 'a' && b <= 'f') {
            return (byte) (b - 'a' + 10);
        } else if (b >= 'A' && b <= 'F') {
            return (byte) (b - 'A' + 10);
        } else {
            throw new IllegalArgumentException("Il carattere non è un valore esadecimale valido.");
        }
    }

    public static void main(String[] args) {
        byte testChar1 = '5'; // Esempio di carattere numerico
        byte testChar2 = 'a'; // Esempio di carattere minuscolo
        byte testChar3 = 'F'; // Esempio di carattere maiuscolo

        System.out.println(convertHexDigit(testChar1)); // Output: 5
        System.out.println(convertHexDigit(testChar2)); // Output: 10
        System.out.println(convertHexDigit(testChar3)); // Output: 15
    }
}