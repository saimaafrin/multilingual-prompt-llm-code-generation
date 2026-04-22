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

// Ejemplo de campo en la clase (si es necesario)
private int lineNumber;

// Constructor (si es necesario)
public YourClassName() {
    this.lineNumber = -1; // Valor inicial que indica que no se ha asignado un número de línea.
}