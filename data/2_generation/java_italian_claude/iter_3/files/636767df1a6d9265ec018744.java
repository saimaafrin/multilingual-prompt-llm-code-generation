import java.util.ArrayList;
import java.util.List;

public class TimeRangeBuilder {

    // Constant for maximum duration between start and end time
    private static final long FETCH_DATA_DURATION = 24 * 60 * 60 * 1000; // 24 hours in milliseconds

    /**
     * Suddivide gli intervalli di tempo per garantire che l'orario di inizio e l'orario di fine siano inferiori a {@link #FETCH_DATA_DURATION}
     */
    protected List<TimeRange> buildTimeRanges(long start, long end) {
        List<TimeRange> ranges = new ArrayList<>();
        
        // If total duration is less than max duration, return single range
        if (end - start <= FETCH_DATA_DURATION) {
            ranges.add(new TimeRange(start, end));
            return ranges;
        }

        // Split into multiple ranges of FETCH_DATA_DURATION
        long currentStart = start;
        while (currentStart < end) {
            long currentEnd = Math.min(currentStart + FETCH_DATA_DURATION, end);
            ranges.add(new TimeRange(currentStart, currentEnd));
            currentStart = currentEnd;
        }

        return ranges;
    }

    // Inner class to represent a time range
    protected static class TimeRange {
        private final long start;
        private final long end;

        public TimeRange(long start, long end) {
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
}