import java.util.ArrayList;
import java.util.List;

public class TimeRangeBuilder {

    private static final long FETCH_DATA_DURATION = 24 * 60 * 60 * 1000; // 24 hours in milliseconds

    /**
     * Divide los rangos de tiempo para asegurar que el tiempo de inicio y el tiempo de finalización sean menores que {@link #FETCH_DATA_DURATION}
     */
    protected List<TimeRange> construirRangosDeTiempo(long inicio, long fin) {
        List<TimeRange> rangos = new ArrayList<>();
        
        while (inicio < fin) {
            long siguienteFin = Math.min(inicio + FETCH_DATA_DURATION, fin);
            rangos.add(new TimeRange(inicio, siguienteFin));
            inicio = siguienteFin;
        }
        
        return rangos;
    }

    // Inner class to represent a time range
    protected static class TimeRange {
        private final long inicio;
        private final long fin;

        public TimeRange(long inicio, long fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        public long getInicio() {
            return inicio;
        }

        public long getFin() {
            return fin;
        }
    }
}