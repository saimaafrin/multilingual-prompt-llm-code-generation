import java.util.ArrayList;
import java.util.List;

public class Label {
    private List<Integer> lineNumbers;

    public Label() {
        this.lineNumbers = new ArrayList<>();
    }

    /**
     * Aggiunge un numero di riga sorgente corrispondente a questa etichetta.
     * @param lineNumber un numero di riga sorgente (che dovrebbe essere strettamente positivo).
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Line number must be strictly positive.");
        }
        this.lineNumbers.add(lineNumber);
    }

    // Optional: Getter method to retrieve the line numbers
    public List<Integer> getLineNumbers() {
        return new ArrayList<>(this.lineNumbers);
    }
}