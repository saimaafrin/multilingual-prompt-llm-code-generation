import java.util.Objects;

public class Label {
    private int sourceLineNumber;
    
    /**
     * Adds a source line number corresponding to this label.
     * @param lineNumber a source line number (which should be strictly positive).
     */
    public void addLineNumber(int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Line number must be strictly positive");
        }
        this.sourceLineNumber = lineNumber;
    }
}