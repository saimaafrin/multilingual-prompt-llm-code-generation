/**
 * Determina se un nome di parametro termina nella posizione attuale, cioè se il carattere fornito può essere considerato un separatore.
 * 
 * @param c il carattere da controllare
 * @return true se il carattere è un separatore, false altrimenti
 */
private static boolean isParameterSeparator(final char c) {
    // Consideriamo come separatori i caratteri che non sono lettere, numeri o underscore
    return !Character.isLetterOrDigit(c) && c != '_';
}