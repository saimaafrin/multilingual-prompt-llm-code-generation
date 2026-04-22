/**
 * Determina se un nome di parametro termina nella posizione attuale, cioè se il carattere fornito può essere considerato un separatore.
 * 
 * @param c il carattere da controllare
 * @return true se il carattere è un separatore, false altrimenti
 */
private static boolean isParameterSeparator(final char c) {
    // Considera spazi, parentesi, virgole, punti e virgola, e altri caratteri non validi per i nomi dei parametri
    return Character.isWhitespace(c) || c == '(' || c == ')' || c == ',' || c == ';' || c == '=' || c == '{' || c == '}';
}