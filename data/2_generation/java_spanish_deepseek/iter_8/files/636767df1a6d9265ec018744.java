import java.util.ArrayList;
import java.util.List;

public class TimeRangeDivider {

    // Supongamos que FETCH_DATA_DURATION es una constante definida en la clase
    private static final long FETCH_DATA_DURATION = 3600; // Por ejemplo, 1 hora en segundos

    /**
     * Divide los rangos de tiempo para asegurar que el tiempo de inicio y el tiempo de finalización sean menores que {@link #FETCH_DATA_DURATION}
     *
     * @param inicio El tiempo de inicio en segundos.
     * @param fin El tiempo de finalización en segundos.
     * @return Una lista de rangos de tiempo divididos.
     */
    protected List<TimeRange> construirRangosDeTiempo(long inicio, long fin) {
        List<TimeRange> rangos = new ArrayList<>();

        while (inicio < fin) {
            long endRange = Math.min(inicio + FETCH_DATA_DURATION, fin);
            rangos.add(new TimeRange(inicio, endRange));
            inicio = endRange;
        }

        return rangos;
    }

    // Clase interna para representar un rango de tiempo
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