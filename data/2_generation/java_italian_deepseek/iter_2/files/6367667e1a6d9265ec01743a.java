import java.util.concurrent.atomic.AtomicLong;

public class LastWriteTimestamp {
    private final AtomicLong lastWriteTimestamp = new AtomicLong(0);

    /**
     * L'ultima volta, in millisecondi, in cui è avvenuta un'operazione di scrittura.
     * @return questo
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimestamp.get();
    }

    /**
     * Aggiorna l'ultimo timestamp di scrittura con il tempo corrente in millisecondi.
     */
    public void updateLastWriteTimestamp() {
        lastWriteTimestamp.set(System.currentTimeMillis());
    }
}