/**
 * Determina si un nombre de parámetro termina en la posición actual, es decir, si el carácter dado califica como un separador.
 * 
 * @param c El carácter a evaluar.
 * @return true si el carácter es un separador, false en caso contrario.
 */
private static boolean esSeparadorDeParametro(final char c) {
    // Consideramos como separadores los espacios en blanco, comas, paréntesis, etc.
    return Character.isWhitespace(c) || c == ',' || c == '(' || c == ')' || c == ';';
}