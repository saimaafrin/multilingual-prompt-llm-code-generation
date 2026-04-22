public class HexConverter {
    /**
     * @param b Un carácter codificado en ASCII de 0-9 a-f A-F
     * @return El valor byte del carácter de 0 a 16.
     */
    public static byte convertHexDigit(byte b) {
        if (b >= '0' && b <= '9') {
            return (byte) (b - '0');
        } else if (b >= 'a' && b <= 'f') {
            return (byte) (b - 'a' + 10);
        } else if (b >= 'A' && b <= 'F') {
            return (byte) (b - 'A' + 10);
        } else {
            throw new IllegalArgumentException("El carácter no es un dígito hexadecimal válido.");
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        byte hexDigit = 'A';
        byte result = convertHexDigit(hexDigit);
        System.out.println("El valor byte de " + (char) hexDigit + " es: " + result);
    }
}