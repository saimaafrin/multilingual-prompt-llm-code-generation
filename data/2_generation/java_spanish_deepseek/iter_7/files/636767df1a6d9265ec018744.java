import java.util.ArrayList;
import java.util.List;

public class TimeRangeDivider {

    // Supongamos que FETCH_DATA_DURATION es una constante definida en la clase
    private static final long FETCH_DATA_DURATION = 3600000; // 1 hora en milisegundos

    /**
     * Divide los rangos de tiempo para asegurar que el tiempo de inicio y el tiempo de finalización sean menores que {@link #FETCH_DATA_DURATION}
     *
     * @param inicio El tiempo de inicio en milisegundos.
     * @param fin El tiempo de finalización en milisegundos.
     * @return Una lista de rangos de tiempo divididos.
     */
    protected List<TimeRange> construirRangosDeTiempo(long inicio, long fin) {
        List<TimeRange> rangos = new ArrayList<>();

        while (inicio < fin) {
            long endTime = Math.min(inicio + FETCH_DATA_DURATION, fin);
            rangos.add(new TimeRange(inicio, endTime));
            inicio = endTime;
        }

        return rangos;
    }

    // Clase interna para representar un rango de tiempo
    public static class TimeRange {
        private final long startTime;
        private final long endTime;

        public TimeRange(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public long getStartTime() {
            return startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        @Override
        public String toString() {
            return "TimeRange{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}