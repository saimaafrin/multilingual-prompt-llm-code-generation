import java.util.Objects;

public class Tag {
    private int lineNumber;

    /**
     * Agrega un número de línea de origen correspondiente a esta etiqueta.
     * @param lineNumber un número de línea de origen (que debe ser estrictamente positivo).
     * @throws IllegalArgumentException si el número de línea no es positivo
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("El número de línea debe ser positivo");
        }
        this.lineNumber = lineNumber;
    }
}