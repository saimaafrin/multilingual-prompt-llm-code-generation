public class ParameterParser {
    /**
     * Determina se un nome di parametro termina nella posizione attuale, cioè se il carattere fornito può essere considerato un separatore.
     * @param c Il carattere da verificare
     * @return true se il carattere è un separatore di parametri, false altrimenti
     */
    private static boolean isParameterSeparator(final char c) {
        return Character.isWhitespace(c) || c == '=' || c == ',' || c == ';' || c == ')';
    }
}