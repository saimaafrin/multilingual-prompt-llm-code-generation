import java.util.ArrayList;
import java.util.List;

public class SourceCodeTagger {
    private List<Integer> lineNumbers;

    public SourceCodeTagger() {
        this.lineNumbers = new ArrayList<>();
    }

    /**
     * 添加与此标签对应的源代码行号。
     * @param lineNumber 一个源代码行号（应为正数）。
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Line number must be a positive integer.");
        }
        this.lineNumbers.add(lineNumber);
    }

    public List<Integer> getLineNumbers() {
        return new ArrayList<>(this.lineNumbers);
    }

    public static void main(String[] args) {
        SourceCodeTagger tagger = new SourceCodeTagger();
        tagger.addLineNumber(10);
        tagger.addLineNumber(20);
        System.out.println(tagger.getLineNumbers()); // Output: [10, 20]
    }
}