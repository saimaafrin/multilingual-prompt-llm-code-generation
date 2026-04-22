public class CharacterUtils {
    /**
     * Interpreta un carattere come una cifra (in qualsiasi base fino a 36) e restituisce il valore numerico. 
     * Questo è simile a {@code Character.digit()} ma non accettiamo cifre non-ASCII.
     */
    private static int digitValue(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        }
        return -1;
    }
}