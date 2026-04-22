import java.util.ArrayList;
import java.util.List;

public class TimeRangeSplitter {

    private static final long FETCH_DATA_DURATION = 3600000; // Example duration in milliseconds (1 hour)

    /**
     * Split time ranges to insure the start time and end time is small then  {@link #FETCH_DATA_DURATION}
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

    public static class TimeRange {
        private long start;
        private long end;

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