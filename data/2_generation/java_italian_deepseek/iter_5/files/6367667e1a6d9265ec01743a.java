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
     * @param timestamp Il nuovo timestamp in millisecondi.
     */
    public void updateLastWriteTimeStamp(long timestamp) {
        lastWriteTimeStamp.set(timestamp);
    }

    public static void main(String[] args) {
        LastWriteTimeStamp example = new LastWriteTimeStamp();
        example.updateLastWriteTimeStamp(System.currentTimeMillis());
        System.out.println("Last write timestamp: " + example.lastWriteTimeStampInMilliseconds());
    }
}