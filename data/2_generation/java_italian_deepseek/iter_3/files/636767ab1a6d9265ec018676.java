/**
 * È una cifra esadecimale?
 * 
 * @param c il carattere da controllare
 * @return true se il carattere è una cifra esadecimale, false altrimenti
 */
private static boolean isHex(final char c) {
    return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
}