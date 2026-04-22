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
     * Aggiorna l'ultimo timestamp di scrittura con il tempo corrente in millisecondi.
     */
    public void updateLastWriteTimeStamp() {
        lastWriteTimeStamp.set(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        LastWriteTimeStamp timestamp = new LastWriteTimeStamp();
        timestamp.updateLastWriteTimeStamp();
        System.out.println("Last write timestamp: " + timestamp.lastWriteTimeStampInMilliseconds());
    }
}