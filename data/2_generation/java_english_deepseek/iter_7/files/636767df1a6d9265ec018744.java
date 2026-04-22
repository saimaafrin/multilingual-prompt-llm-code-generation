import java.util.ArrayList;
import java.util.List;

public class TimeRangeSplitter {

    private static final long FETCH_DATA_DURATION = 3600 * 1000; // 1 hour in milliseconds

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
        List<TimeRange> ranges = splitter.buildTimeRanges(1633072800000L, 1633094400000L);
        for (TimeRange range : ranges) {
            System.out.println(range);
        }
    }
}