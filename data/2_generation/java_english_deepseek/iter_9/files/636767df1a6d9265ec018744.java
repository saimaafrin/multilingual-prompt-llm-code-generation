import java.util.ArrayList;
import java.util.List;

public class TimeRangeSplitter {

    private static final long FETCH_DATA_DURATION = 3600 * 1000; // 1 hour in milliseconds

    /**
     * Split time ranges to ensure the start time and end time is smaller than {@link #FETCH_DATA_DURATION}
     *
     * @param start The start time in milliseconds.
     * @param end The end time in milliseconds.
     * @return A list of TimeRange objects representing the split time ranges.
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