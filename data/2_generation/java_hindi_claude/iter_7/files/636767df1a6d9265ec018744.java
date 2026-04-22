import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TimeRangeSplitter {
    
    // Maximum duration between start and end time (e.g. 24 hours)
    private static final Duration FETCH_DATA_DURATION = Duration.ofHours(24);

    /**
     * Split time ranges to insure the start time and end time is smaller than FETCH_DATA_DURATION
     * @param startTime Start time as Instant
     * @param endTime End time as Instant
     * @return List of TimeRange objects containing split time ranges
     */
    public List<TimeRange> splitTimeRanges(Instant startTime, Instant endTime) {
        List<TimeRange> timeRanges = new ArrayList<>();
        
        // If duration is less than max, return single range
        if (Duration.between(startTime, endTime).compareTo(FETCH_DATA_DURATION) <= 0) {
            timeRanges.add(new TimeRange(startTime, endTime));
            return timeRanges;
        }

        // Split into multiple ranges
        Instant currentStart = startTime;
        while (currentStart.isBefore(endTime)) {
            Instant currentEnd = currentStart.plus(FETCH_DATA_DURATION);
            
            // If current end would exceed total end time, use total end time
            if (currentEnd.isAfter(endTime)) {
                currentEnd = endTime;
            }
            
            timeRanges.add(new TimeRange(currentStart, currentEnd));
            currentStart = currentEnd;
        }
        
        return timeRanges;
    }

    // Inner class to hold time range pairs
    public static class TimeRange {
        private final Instant start;
        private final Instant end;

        public TimeRange(Instant start, Instant end) {
            this.start = start;
            this.end = end;
        }

        public Instant getStart() {
            return start;
        }

        public Instant getEnd() {
            return end;
        }
    }
}