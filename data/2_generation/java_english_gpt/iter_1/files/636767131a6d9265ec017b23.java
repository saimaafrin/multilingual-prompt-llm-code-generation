public class Label {
    private int lineNumber;

    /** 
     * Adds a source line number corresponding to this label.
     * @param lineNumber a source line number (which should be strictly positive).
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Line number must be strictly positive.");
        }
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public static void main(String[] args) {
        Label label = new Label();
        label.addLineNumber(10);
        System.out.println("Line number added: " + label.getLineNumber());
    }
}