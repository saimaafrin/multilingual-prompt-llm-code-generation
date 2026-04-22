import java.util.ArrayList;
import java.util.List;

public class TimeRangeBuilder {

    // Assuming FETCH_DATA_DURATION is a constant representing the maximum duration in milliseconds
    private static final long FETCH_DATA_DURATION = 3600000; // 1 hour in milliseconds

    /**
     * Suddivide gli intervalli di tempo per garantire che l'orario di inizio e l'orario di fine siano inferiori a {@link #FETCH_DATA_DURATION}
     *
     * @param start L'orario di inizio in millisecondi.
     * @param end L'orario di fine in millisecondi.
     * @return Una lista di intervalli di tempo suddivisi.
     */
    protected List<TimeRange> buildTimeRanges(long start, long end) {
        List<TimeRange> timeRanges = new ArrayList<>();

        while (start < end) {
            long nextEnd = Math.min(start + FETCH_DATA_DURATION, end);
            timeRanges.add(new TimeRange(start, nextEnd));
            start = nextEnd;
        }

        return timeRanges;
    }

    // Inner class to represent a time range
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