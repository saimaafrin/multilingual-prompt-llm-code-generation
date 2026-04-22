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
        
        // Get current sequence number
        long currentSequence = getCurrentSequence();
        
        // Build sequence ranges in chunks of 1000
        long chunkSize = 1000;
        long startSequence = 0;
        
        while (startSequence < currentSequence) {
            long endSequence = Math.min(startSequence + chunkSize - 1, currentSequence);
            ranges.add(new SequenceRange(startSequence, endSequence));
            startSequence = endSequence + 1;
        }
        
        return ranges;
    }
    
    private long getCurrentSequence() {
        // Implementation to get current sequence number
        // This could be from a database, file, or other source
        return System.currentTimeMillis();
    }
}