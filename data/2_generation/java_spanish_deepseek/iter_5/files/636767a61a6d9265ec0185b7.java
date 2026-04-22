/**
 * Interpreta un carácter como un dígito (en cualquier base hasta 36) y devuelve el valor numérico. 
 * Esto es similar a {@code Character.digit()} pero no aceptamos dígitos no ASCII.
 */
private static int valorDígito(final char c) {
    if (c >= '0' && c <= '9') {
        return c - '0';
    } else if (c >= 'A' && c <= 'Z') {
        return 10 + (c - 'A');
    } else if (c >= 'a' && c <= 'z') {
        return 10 + (c - 'a');
    } else {
        throw new IllegalArgumentException("El carácter no es un dígito válido en ninguna base hasta 36.");
    }
}