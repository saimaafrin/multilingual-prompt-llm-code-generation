import java.util.ArrayList;
import java.util.List;

public class TimeRangeSplitter {

    // Assuming FETCH_DATA_DURATION is a constant representing the maximum duration in milliseconds
    private static final long FETCH_DATA_DURATION = 24 * 60 * 60 * 1000; // 24 hours in milliseconds

    /**
     * 拆分时间范围以确保开始时间和结束时间小于 {@link #FETCH_DATA_DURATION}
     *
     * @param start 开始时间（毫秒）
     * @param end   结束时间（毫秒）
     * @return 拆分后的时间范围列表
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

    // Assuming TimeRange is a simple class representing a time range
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
        long start = System.currentTimeMillis() - 2 * FETCH_DATA_DURATION;
        long end = System.currentTimeMillis();
        List<TimeRange> timeRanges = splitter.buildTimeRanges(start, end);
        timeRanges.forEach(System.out::println);
    }
}