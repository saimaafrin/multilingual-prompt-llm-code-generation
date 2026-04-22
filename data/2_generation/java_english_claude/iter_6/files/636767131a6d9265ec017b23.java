import java.util.Objects;

public class Label {
    private int sourceLineNumber;
    
    /**
     * Adds a source line number corresponding to this label.
     * @param lineNumber a source line number (which should be strictly positive).
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Line number must be positive");
        }
        this.sourceLineNumber = lineNumber;
    }
}