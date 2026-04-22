import java.util.ArrayList;
import java.util.List;

public class TimeRangeSplitter {

    // Assuming FETCH_DATA_DURATION is a constant representing the maximum allowed duration
    private static final long FETCH_DATA_DURATION = 3600000; // Example: 1 hour in milliseconds

    protected List<TimeRange> buildTimeRanges(long start, long end) {
        List<TimeRange> timeRanges = new ArrayList<>();

        while (start < end) {
            long rangeEnd = Math.min(start + FETCH_DATA_DURATION, end);
            timeRanges.add(new TimeRange(start, rangeEnd));
            start = rangeEnd;
        }

        return timeRanges;
    }

    // Assuming TimeRange is a class that holds start and end times
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

    // Example usage
    public static void main(String[] args) {
        TimeRangeSplitter splitter = new TimeRangeSplitter();
        List<TimeRange> ranges = splitter.buildTimeRanges(1609459200000L, 1609462800000L); // Example timestamps
        for (TimeRange range : ranges) {
            System.out.println(range);
        }
    }
}