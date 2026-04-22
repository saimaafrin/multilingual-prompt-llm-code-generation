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

public class ProfileSnapshot {

    /**
     * costruisce l'intervallo di sequenze per lo snapshot dei profili correnti
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> ranges = new ArrayList<>();
        // Example implementation: create a single range from 1 to 100
        ranges.add(new SequenceRange(1, 100));
        return ranges;
    }
}