import java.util.ArrayList;
import java.util.List;

public class SequenceRangeBuilder {

    /**
     * build current profiles segment snapshot search sequence ranges
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> sequenceRanges = new ArrayList<>();
        
        // Example logic to build sequence ranges
        // This is just a placeholder; actual logic will depend on specific requirements
        for (int i = 0; i < 10; i++) {
            int start = i * 10;
            int end = start + 9;
            sequenceRanges.add(new SequenceRange(start, end));
        }
        
        return sequenceRanges;
    }

    public static void main(String[] args) {
        SequenceRangeBuilder builder = new SequenceRangeBuilder();
        List<SequenceRange> ranges = builder.buildSequenceRanges();
        for (SequenceRange range : ranges) {
            System.out.println(range);
        }
    }
}

class SequenceRange {
    private int start;
    private int end;

    public SequenceRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "SequenceRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}