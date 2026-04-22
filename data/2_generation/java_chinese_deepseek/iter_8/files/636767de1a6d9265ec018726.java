import java.util.ArrayList;
import java.util.List;

public class ConfigSnapshot {

    public List<SequenceRange> buildSequenceRanges() {
        // Assuming SequenceRange is a class that represents a range of sequences
        List<SequenceRange> sequenceRanges = new ArrayList<>();

        // Example logic to build sequence ranges
        // This is a placeholder and should be replaced with actual logic
        sequenceRanges.add(new SequenceRange(1, 100));
        sequenceRanges.add(new SequenceRange(101, 200));
        sequenceRanges.add(new SequenceRange(201, 300));

        return sequenceRanges;
    }

    // Assuming SequenceRange is a class that represents a range of sequences
    public static class SequenceRange {
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

    public static void main(String[] args) {
        ConfigSnapshot configSnapshot = new ConfigSnapshot();
        List<SequenceRange> ranges = configSnapshot.buildSequenceRanges();
        for (SequenceRange range : ranges) {
            System.out.println(range);
        }
    }
}