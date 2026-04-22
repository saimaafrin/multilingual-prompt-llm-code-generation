import java.util.ArrayList;
import java.util.List;

public class TimeRangeBuilder {

    private static final long FETCH_DATA_DURATION = 3600000; // Example duration in milliseconds (1 hour)

    /**
     * समय सीमा को विभाजित करें ताकि प्रारंभ समय और समाप्ति समय {@link #FETCH_DATA_DURATION} से छोटा हो
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

    public static void main(String[] args) {
        TimeRangeBuilder builder = new TimeRangeBuilder();
        List<TimeRange> ranges = builder.buildTimeRanges(0, 10000000); // Example usage
        for (TimeRange range : ranges) {
            System.out.println(range);
        }
    }
}