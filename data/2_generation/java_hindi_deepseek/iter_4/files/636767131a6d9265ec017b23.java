import java.util.ArrayList;
import java.util.List;

public class Label {
    private List<Integer> lineNumbers;

    public Label() {
        this.lineNumbers = new ArrayList<>();
    }

    /**
     * इस लेबल के लिए एक स्रोत पंक्ति संख्या जोड़ता है।
     * @param lineNumber एक स्रोत पंक्ति संख्या (जो कि सख्ती से सकारात्मक होनी चाहिए)।
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Line number must be strictly positive.");
        }
        this.lineNumbers.add(lineNumber);
    }

    // Optional: Method to get the list of line numbers
    public List<Integer> getLineNumbers() {
        return new ArrayList<>(this.lineNumbers);
    }
}