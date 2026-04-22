import java.util.ArrayList;
import java.util.List;

public class TimeRangeBuilder {

    // Maximum duration between start and end time in milliseconds (24 hours)
    private static final long FETCH_DATA_DURATION = 24 * 60 * 60 * 1000L;

    /**
     * 拆分时间范围以确保开始时间和结束时间小于 {@link #FETCH_DATA_DURATION}
     */
    protected List<TimeRange> buildTimeRanges(long start, long end) {
        List<TimeRange> ranges = new ArrayList<>();
        
        // If duration is less than FETCH_DATA_DURATION, return single range
        if (end - start <= FETCH_DATA_DURATION) {
            ranges.add(new TimeRange(start, end));
            return ranges;
        }

        // Split into multiple ranges
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