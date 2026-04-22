import java.util.ArrayList;
import java.util.List;

public class Label {
    private List<Integer> lineNumbers;

    public Label() {
        lineNumbers = new ArrayList<>();
    }

    /**
     * 添加与此标签对应的源代码行号。
     * @param lineNumber 一个源代码行号（应为正数）。
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Line number must be positive");
        }
        
        if (lineNumbers == null) {
            lineNumbers = new ArrayList<>();
        }
        
        lineNumbers.add(lineNumber);
    }
}