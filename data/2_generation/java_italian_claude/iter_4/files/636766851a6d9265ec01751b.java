public class HexDecoder {
    /**
     * Funzione di supporto per decodificare metà di un numero esadecimale da una stringa.
     * @param c Il carattere ASCII del numero esadecimale da decodificare. Deve essere compreso nell'intervallo {@code [0-9a-fA-F]}.
     * @return Il valore esadecimale rappresentato dal carattere ASCII fornito, oppure {@link Character#MAX_VALUE} se il carattere non è valido.
     */
    private static char decodeHexNibble(final char c) {
        // Per cifre da 0-9
        if (c >= '0' && c <= '9') {
            return (char)(c - '0');
        }
        
        // Per lettere minuscole a-f
        if (c >= 'a' && c <= 'f') {
            return (char)(c - 'a' + 10);
        }
        
        // Per lettere maiuscole A-F
        if (c >= 'A' && c <= 'F') {
            return (char)(c - 'A' + 10);
        }
        
        // Carattere non valido
        return Character.MAX_VALUE;
    }
}