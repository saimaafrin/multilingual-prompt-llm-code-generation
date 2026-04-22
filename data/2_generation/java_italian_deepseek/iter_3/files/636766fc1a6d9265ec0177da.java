/**
 * Determina se un nome di parametro termina nella posizione attuale, cioè se il carattere fornito può essere considerato un separatore.
 * 
 * @param c Il carattere da controllare.
 * @return true se il carattere è un separatore, false altrimenti.
 */
private static boolean isParameterSeparator(final char c) {
    // Considera come separatori i caratteri non validi per i nomi di parametri, come spazi, parentesi, virgole, ecc.
    return !Character.isLetterOrDigit(c) && c != '_';
}