import java.util.ArrayList;
import java.util.List;

public class TimeRangeSplitter {

    // Assuming FETCH_DATA_DURATION is a constant representing the maximum duration in milliseconds
    private static final long FETCH_DATA_DURATION = 24 * 60 * 60 * 1000; // 24 hours in milliseconds

    /**
     * 拆分时间范围以确保开始时间和结束时间小于 {@link #FETCH_DATA_DURATION}
     */
    protected List<TimeRange> buildTimeRanges(long start, long end) {
        List<TimeRange> timeRanges = new ArrayList<>();
        long currentStart = start;

        while (currentStart < end) {
            long currentEnd = Math.min(currentStart + FETCH_DATA_DURATION, end);
            timeRanges.add(new TimeRange(currentStart, currentEnd));
            currentStart = currentEnd;
        }

        return timeRanges;
    }

    // Inner class representing a time range
    public static class TimeRange {
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

        @Override
        public String toString() {
            return "TimeRange{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}