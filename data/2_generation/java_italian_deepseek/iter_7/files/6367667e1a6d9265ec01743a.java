import java.util.concurrent.atomic.AtomicLong;

public class LastWriteTimeStamp {
    private final AtomicLong lastWriteTimeStamp = new AtomicLong();

    /**
     * L'ultima volta, in millisecondi, in cui è avvenuta un'operazione di scrittura.
     * @return questo
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp.get();
    }

    /**
     * Aggiorna il timestamp dell'ultima operazione di scrittura.
     */
    public void updateLastWriteTimeStamp() {
        lastWriteTimeStamp.set(System.currentTimeMillis());
    }
}