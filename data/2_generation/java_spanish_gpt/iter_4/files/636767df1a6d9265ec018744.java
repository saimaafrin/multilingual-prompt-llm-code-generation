import java.util.ArrayList;
import java.util.List;

public class TimeRangeBuilder {

    private static final long FETCH_DATA_DURATION = 3600000; // Example duration in milliseconds (1 hour)

    /**
     * Divide los rangos de tiempo para asegurar que el tiempo de inicio y el tiempo de finalización sean menores que {@link #FETCH_DATA_DURATION}
     */
    protected List<TimeRange> construirRangosDeTiempo(long inicio, long fin) {
        List<TimeRange> timeRanges = new ArrayList<>();

        if (fin - inicio > FETCH_DATA_DURATION) {
            long currentStart = inicio;
            while (currentStart < fin) {
                long currentEnd = Math.min(currentStart + FETCH_DATA_DURATION, fin);
                timeRanges.add(new TimeRange(currentStart, currentEnd));
                currentStart = currentEnd;
            }
        } else {
            timeRanges.add(new TimeRange(inicio, fin));
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