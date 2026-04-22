/**
 * Controlla se il carattere è un carattere alfabetico maiuscolo ASCII a 7 bit.
 * 
 * @param ch il carattere da controllare
 * @return true se compreso tra 65 e 90 inclusi
 */
public static boolean isAsciiAlphaUpper(final char ch) {
    return ch >= 'A' && ch <= 'Z';
}