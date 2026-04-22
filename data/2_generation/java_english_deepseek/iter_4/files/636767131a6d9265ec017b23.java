/**
 * Adds a source line number corresponding to this label.
 * @param lineNumber a source line number (which should be strictly positive).
 */
final void addLineNumber(final int lineNumber) {
    if (lineNumber <= 0) {
        throw new IllegalArgumentException("Line number must be strictly positive.");
    }
    // Assuming there is a list or some data structure to store line numbers
    // For example, a List<Integer> lineNumbers;
    lineNumbers.add(lineNumber);
}