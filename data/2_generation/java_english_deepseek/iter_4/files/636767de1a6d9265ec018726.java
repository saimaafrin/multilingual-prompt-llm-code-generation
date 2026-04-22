import java.util.ArrayList;
import java.util.List;

public class SequenceRange {
    private int start;
    private int end;

    public SequenceRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "SequenceRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class ProfileBuilder {

    /**
     * build current profiles segment snapshot search sequence ranges
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> ranges = new ArrayList<>();
        
        // Example logic to create sequence ranges
        ranges.add(new SequenceRange(1, 100));
        ranges.add(new SequenceRange(101, 200));
        ranges.add(new SequenceRange(201, 300));
        
        return ranges;
    }

    public static void main(String[] args) {
        ProfileBuilder builder = new ProfileBuilder();
        List<SequenceRange> sequenceRanges = builder.buildSequenceRanges();
        for (SequenceRange range : sequenceRanges) {
            System.out.println(range);
        }
    }
}