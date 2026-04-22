/**
 * Determina si un carácter es un dígito hexadecimal.
 * Un dígito hexadecimal es un carácter que está en el rango de '0' a '9',
 * 'a' a 'f' (minúsculas), o 'A' a 'F' (mayúsculas).
 *
 * @param c El carácter a verificar.
 * @return true si el carácter es un dígito hexadecimal, false en caso contrario.
 */
private static boolean esHex(final char c) {
    return (c >= '0' && c <= '9') || 
           (c >= 'a' && c <= 'f') || 
           (c >= 'A' && c <= 'F');
}