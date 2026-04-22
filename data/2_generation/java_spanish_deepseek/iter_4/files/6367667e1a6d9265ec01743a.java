import java.util.concurrent.atomic.AtomicLong;

public class WriteOperationTracker {
    private final AtomicLong lastWriteTimeStamp = new AtomicLong();

    /**
     * La última vez, en milisegundos, que ocurrió una operación de escritura.
     * @return el último timestamp de escritura en milisegundos.
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp.get();
    }

    /**
     * Actualiza el último timestamp de escritura al tiempo actual en milisegundos.
     */
    public void updateWriteTimeStamp() {
        lastWriteTimeStamp.set(System.currentTimeMillis());
    }
}