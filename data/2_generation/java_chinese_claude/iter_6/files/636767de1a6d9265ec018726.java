import java.util.ArrayList;
import java.util.List;

public class SequenceRangeBuilder {

    private static class SequenceRange {
        private long start;
        private long end;
        
        public SequenceRange(long start, long end) {
            this.start = start;
            this.end = end;
        }
        
        public long getStart() {
            return start;
        }
        
        public long getEnd() {
            return end; 
        }
    }

    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> ranges = new ArrayList<>();
        
        // Get current sequence number
        long currentSequence = getCurrentSequence();
        
        // Build ranges in chunks of 1000
        long chunkSize = 1000;
        long start = 0;
        
        while (start < currentSequence) {
            long end = Math.min(start + chunkSize - 1, currentSequence);
            ranges.add(new SequenceRange(start, end));
            start = end + 1;
        }
        
        return ranges;
    }
    
    // Helper method to get current sequence
    private long getCurrentSequence() {
        // Implementation to get current sequence number
        // This could come from a database or other source
        return System.currentTimeMillis();
    }
}