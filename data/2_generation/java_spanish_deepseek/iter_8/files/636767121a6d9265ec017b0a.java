/**
 * Omite bytes hasta el final de la línea actual.
 * @param headerPart Las cabeceras que se están analizando.
 * @param end Índice del último byte que aún no ha sido procesado.
 * @return Índice de la secuencia \r\n, que indica el final de la línea.
 */
private int parseEndOfLine(String headerPart, int end) {
    int index = end;
    while (index < headerPart.length()) {
        char currentChar = headerPart.charAt(index);
        if (currentChar == '\r') {
            if (index + 1 < headerPart.length() && headerPart.charAt(index + 1) == '\n') {
                return index;
            }
        }
        index++;
    }
    return -1; // Si no se encuentra el final de la línea, retorna -1
}