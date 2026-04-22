/**
 * Salta i byte fino alla fine della riga corrente.
 * @param headerPart Le intestazioni che vengono analizzate.
 * @param end Indice dell'ultimo byte che deve ancora essere elaborato.
 * @return Indice della sequenza \r\n, che indica la fine della riga.
 */
private int parseEndOfLine(String headerPart, int end) {
    int index = end;
    while (index < headerPart.length()) {
        char currentChar = headerPart.charAt(index);
        if (currentChar == '\r' && index + 1 < headerPart.length() && headerPart.charAt(index + 1) == '\n') {
            return index;
        }
        index++;
    }
    return -1; // Se non viene trovata la sequenza \r\n
}