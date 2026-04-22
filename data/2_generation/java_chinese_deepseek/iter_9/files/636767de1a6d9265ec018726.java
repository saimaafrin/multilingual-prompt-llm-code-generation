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

public class ConfigSnapshot {
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> ranges = new ArrayList<>();
        // Example logic to build sequence ranges
        ranges.add(new SequenceRange(0, 100));
        ranges.add(new SequenceRange(101, 200));
        ranges.add(new SequenceRange(201, 300));
        return ranges;
    }

    public static void main(String[] args) {
        ConfigSnapshot snapshot = new ConfigSnapshot();
        List<SequenceRange> ranges = snapshot.buildSequenceRanges();
        for (SequenceRange range : ranges) {
            System.out.println(range);
        }
    }
}