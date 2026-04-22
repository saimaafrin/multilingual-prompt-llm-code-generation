/**
 * Agrega un número de línea de origen correspondiente a esta etiqueta.
 * @param lineNumber un número de línea de origen (que debe ser estrictamente positivo).
 */
final void addLineNumber(final int lineNumber) {
    if (lineNumber <= 0) {
        throw new IllegalArgumentException("El número de línea debe ser estrictamente positivo.");
    }
    // Aquí iría la lógica para agregar el número de línea a la etiqueta.
    // Por ejemplo, podrías tener un campo en la clase para almacenar el número de línea.
    this.lineNumber = lineNumber;
}