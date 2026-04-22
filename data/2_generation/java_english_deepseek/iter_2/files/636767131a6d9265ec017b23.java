/**
 * Adds a source line number corresponding to this label.
 * @param lineNumber a source line number (which should be strictly positive).
 */
final void addLineNumber(final int lineNumber) {
    if (lineNumber <= 0) {
        throw new IllegalArgumentException("Line number must be strictly positive.");
    }
    // Assuming there is a list or collection to store line numbers
    // For example, if there is a List<Integer> lineNumbers field in the class
    this.lineNumbers.add(lineNumber);
}