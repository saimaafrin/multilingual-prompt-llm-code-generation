import java.util.ArrayList;
import java.util.List;

public class SequenceRangeBuilder {

    /** 
     * build current profiles segment snapshot search sequence ranges
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> sequenceRanges = new ArrayList<>();
        
        // Example logic to build sequence ranges
        // This is a placeholder and should be replaced with actual logic
        for (int i = 0; i < 10; i++) {
            SequenceRange range = new SequenceRange(i * 10, (i + 1) * 10 - 1);
            sequenceRanges.add(range);
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