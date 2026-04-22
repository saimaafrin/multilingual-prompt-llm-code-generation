import java.util.ArrayList;
import java.util.List;

public class TimeRangeDivider {

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
        long tiempoActual = inicio;

        while (tiempoActual < fin) {
            long tiempoSiguiente = tiempoActual + FETCH_DATA_DURATION;
            if (tiempoSiguiente > fin) {
                tiempoSiguiente = fin;
            }
            rangos.add(new TimeRange(tiempoActual, tiempoSiguiente));
            tiempoActual = tiempoSiguiente;
        }

        return rangos;
    }

    public static class TimeRange {
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

        @Override
        public String toString() {
            return "TimeRange{" +
                    "inicio=" + inicio +
                    ", fin=" + fin +
                    '}';
        }
    }
}