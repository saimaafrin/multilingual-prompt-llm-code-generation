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

public class ProfileSegment {

    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> ranges = new ArrayList<>();
        // Example logic to build sequence ranges
        // This is a placeholder and should be replaced with actual logic
        ranges.add(new SequenceRange(1, 10));
        ranges.add(new SequenceRange(11, 20));
        ranges.add(new SequenceRange(21, 30));
        return ranges;
    }

    public static void main(String[] args) {
        ProfileSegment segment = new ProfileSegment();
        List<SequenceRange> sequenceRanges = segment.buildSequenceRanges();
        for (SequenceRange range : sequenceRanges) {
            System.out.println(range);
        }
    }
}