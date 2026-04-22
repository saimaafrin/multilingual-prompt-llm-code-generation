/**
 * इस लेबल के लिए एक स्रोत पंक्ति संख्या जोड़ता है।
 * @param lineNumber एक स्रोत पंक्ति संख्या (जो कि सख्ती से सकारात्मक होनी चाहिए)।
 */
final void addLineNumber(final int lineNumber) {
    if (lineNumber <= 0) {
        throw new IllegalArgumentException("Line number must be strictly positive.");
    }
    // Assuming there is a list or some data structure to store line numbers
    // For example, using a List<Integer> to store line numbers
    // If the list is not initialized, initialize it
    if (this.lineNumbers == null) {
        this.lineNumbers = new ArrayList<>();
    }
    this.lineNumbers.add(lineNumber);
}

// Assuming the class has a field to store line numbers
private List<Integer> lineNumbers;