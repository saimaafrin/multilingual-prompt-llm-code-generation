import java.util.Objects;

public class Label {
    private int lineNumber;
    
    /**
     * Aggiunge un numero di riga sorgente corrispondente a questa etichetta.
     * @param lineNumber un numero di riga sorgente (che dovrebbe essere strettamente positivo).
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Il numero di riga deve essere strettamente positivo");
        }
        this.lineNumber = lineNumber;
    }
}