/**
 * Determina se un nome di parametro termina nella posizione attuale, cioè se il carattere fornito può essere considerato un separatore.
 * 
 * @param c Il carattere da controllare.
 * @return true se il carattere è un separatore, false altrimenti.
 */
private static boolean isParameterSeparator(final char c) {
    // Consideriamo come separatori spazi, virgole, parentesi chiuse, punti e virgola, ecc.
    return c == ' ' || c == ',' || c == ')' || c == ';' || c == '\t' || c == '\n' || c == '\r';
}