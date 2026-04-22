public class HexDecoder {
    /**
     * Ayudante para decodificar la mitad de un número hexadecimal a partir de una cadena.
     * @param c El carácter ASCII del número hexadecimal a decodificar. Debe estar en el rango {@code [0-9a-fA-F]}.
     * @return El valor hexadecimal representado en el carácter ASCII dado, o {@link Character#MAX_VALUE} si el carácter es inválido.
     */
    private static char decodeHexNibble(final char c) {
        // Para dígitos 0-9
        if (c >= '0' && c <= '9') {
            return (char)(c - '0');
        }
        
        // Para letras a-f
        if (c >= 'a' && c <= 'f') {
            return (char)(c - 'a' + 10);
        }
        
        // Para letras A-F
        if (c >= 'A' && c <= 'F') {
            return (char)(c - 'A' + 10);
        }
        
        // Carácter inválido
        return Character.MAX_VALUE;
    }
}