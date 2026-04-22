/**
 * Agrega un número de línea de origen correspondiente a esta etiqueta.
 * @param lineNumber un número de línea de origen (que debe ser estrictamente positivo).
 */
final void addLineNumber(final int lineNumber) {
    if (lineNumber <= 0) {
        throw new IllegalArgumentException("El número de línea debe ser estrictamente positivo.");
    }
    // Aquí se podría agregar la lógica para almacenar o procesar el número de línea.
    // Por ejemplo, si se tiene una lista de números de línea:
    // this.lineNumbers.add(lineNumber);
}