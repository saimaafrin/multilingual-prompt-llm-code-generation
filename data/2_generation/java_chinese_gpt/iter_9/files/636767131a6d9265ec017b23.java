public class LineNumberManager {
    private List<Integer> lineNumbers;

    public LineNumberManager() {
        lineNumbers = new ArrayList<>();
    }

    /**
     * 添加与此标签对应的源代码行号。
     * @param lineNumber 一个源代码行号（应为正数）。
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Line number must be a positive integer.");
        }
        lineNumbers.add(lineNumber);
    }

    public List<Integer> getLineNumbers() {
        return new ArrayList<>(lineNumbers);
    }

    public static void main(String[] args) {
        LineNumberManager manager = new LineNumberManager();
        manager.addLineNumber(10);
        manager.addLineNumber(20);
        System.out.println(manager.getLineNumbers());
    }
}