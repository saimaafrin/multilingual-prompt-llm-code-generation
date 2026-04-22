import java.util.ArrayList;
import java.util.List;

public class Label {
    private List<Integer> lineNumbers;

    public Label() {
        this.lineNumbers = new ArrayList<>();
    }

    /**
     * Adds a source line number corresponding to this label.
     * @param lineNumber a source line number (which should be strictly positive).
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Line number must be strictly positive.");
        }
        this.lineNumbers.add(lineNumber);
    }

    // Optional: Getter method to retrieve the list of line numbers
    public List<Integer> getLineNumbers() {
        return new ArrayList<>(this.lineNumbers);
    }
}