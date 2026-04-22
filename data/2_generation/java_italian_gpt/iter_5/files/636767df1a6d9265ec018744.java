import java.util.ArrayList;
import java.util.List;

public class TimeRangeBuilder {

    private static final long FETCH_DATA_DURATION = 3600000; // Example duration in milliseconds (1 hour)

    /**
     * Suddivide gli intervalli di tempo per garantire che l'orario di inizio e l'orario di fine siano inferiori a {@link #FETCH_DATA_DURATION}
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