/**
 * Determina se un nome di parametro termina nella posizione attuale, cioè se il carattere fornito può essere considerato un separatore.
 */
private static boolean isParameterSeparator(final char c) {
    // Consideriamo come separatori i caratteri che non sono lettere, numeri o underscore
    return !Character.isLetterOrDigit(c) && c != '_';
}