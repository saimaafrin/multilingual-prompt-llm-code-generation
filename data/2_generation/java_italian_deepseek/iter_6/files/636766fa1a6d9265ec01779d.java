/**
 * Controlla se il carattere è un controllo ASCII a 7 bit.
 * 
 * @param ch il carattere da controllare
 * @return true se è minore di 32 o uguale a 127
 */
public static boolean isAsciiControl(final char ch) {
    return ch < 32 || ch == 127;
}