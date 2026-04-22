import java.util.concurrent.atomic.AtomicLong;

public class WriteOperationTracker {
    private final AtomicLong lastWriteTimeStamp = new AtomicLong(0);

    /**
     * La última vez, en milisegundos, que ocurrió una operación de escritura.
     * @return el último timestamp de escritura en milisegundos.
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp.get();
    }

    /**
     * Actualiza el último timestamp de escritura con el tiempo actual en milisegundos.
     */
    public void updateWriteTimeStamp() {
        lastWriteTimeStamp.set(System.currentTimeMillis());
    }
}