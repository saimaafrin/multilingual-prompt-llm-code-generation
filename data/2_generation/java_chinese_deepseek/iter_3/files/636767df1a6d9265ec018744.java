import java.util.ArrayList;
import java.util.List;

public class TimeRangeSplitter {

    // Assuming FETCH_DATA_DURATION is a constant representing the maximum duration allowed
    private static final long FETCH_DATA_DURATION = 3600000; // 1 hour in milliseconds

    /**
     * 拆分时间范围以确保开始时间和结束时间小于 {@link #FETCH_DATA_DURATION}
     */
    protected List<TimeRange> buildTimeRanges(long start, long end) {
        List<TimeRange> timeRanges = new ArrayList<>();

        while (start < end) {
            long rangeEnd = Math.min(start + FETCH_DATA_DURATION, end);
            timeRanges.add(new TimeRange(start, rangeEnd));
            start = rangeEnd;
        }

        return timeRanges;
    }

    // Assuming TimeRange is a class that represents a time range
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

    public static void main(String[] args) {
        TimeRangeSplitter splitter = new TimeRangeSplitter();
        long startTime = 1633024800000L; // Example start time
        long endTime = 1633039200000L;   // Example end time

        List<TimeRange> ranges = splitter.buildTimeRanges(startTime, endTime);
        for (TimeRange range : ranges) {
            System.out.println(range);
        }
    }
}