/**
 * Método de utilidad para {@link #createNumber(String)}.
 * Devuelve <code>true</code> si "s" es <code>null</code> o si todos los caracteres en la cadena son ceros.
 * @param s la cadena a verificar
 * @return si son todos ceros o <code>null</code>
 */
private static boolean isAllZeros(String s) {
    if (s == null) {
        return true;
    }
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != '0') {
            return false;
        }
    }
    return true;
}