import java.util.ArrayList;
import java.util.List;

public class SequenceRangeBuilder {

    private static class SequenceRange {
        private long startSequence;
        private long endSequence;

        public SequenceRange(long startSequence, long endSequence) {
            this.startSequence = startSequence;
            this.endSequence = endSequence;
        }

        public long getStartSequence() {
            return startSequence;
        }

        public long getEndSequence() {
            return endSequence;
        }
    }

    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> ranges = new ArrayList<>();
        
        // Get current snapshot sequence
        long currentSequence = getCurrentSequence();
        
        // Build sequence ranges with fixed size intervals
        long interval = 1000;
        long start = 0;
        
        while (start < currentSequence) {
            long end = Math.min(start + interval, currentSequence);
            ranges.add(new SequenceRange(start, end));
            start = end + 1;
        }
        
        return ranges;
    }

    // Helper method to get current sequence
    private long getCurrentSequence() {
        // Implementation to get current sequence number
        return System.currentTimeMillis();
    }
}