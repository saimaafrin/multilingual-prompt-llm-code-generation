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
     * वर्तमान प्रोफाइल खंड स्नैपशॉट खोज अनुक्रम सीमा बनाएं
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> sequenceRanges = new ArrayList<>();
        
        // Example logic to create sequence ranges
        sequenceRanges.add(new SequenceRange(0, 10));
        sequenceRanges.add(new SequenceRange(11, 20));
        sequenceRanges.add(new SequenceRange(21, 30));
        
        return sequenceRanges;
    }

    public static void main(String[] args) {
        ProfileSnapshot snapshot = new ProfileSnapshot();
        List<SequenceRange> ranges = snapshot.buildSequenceRanges();
        for (SequenceRange range : ranges) {
            System.out.println(range);
        }
    }
}