/**
 * इस लेबल के लिए एक स्रोत पंक्ति संख्या जोड़ता है।
 * @param lineNumber एक स्रोत पंक्ति संख्या (जो कि सख्ती से सकारात्मक होनी चाहिए)।
 */
final void addLineNumber(final int lineNumber) {
    if (lineNumber <= 0) {
        throw new IllegalArgumentException("Line number must be strictly positive.");
    }
    // Assuming there is a list or some data structure to store the line numbers
    // For example, a List<Integer> lineNumbers;
    lineNumbers.add(lineNumber);
}