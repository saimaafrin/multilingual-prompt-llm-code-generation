import java.util.concurrent.atomic.AtomicLong;

public class LastWriteTimeStamp {
    private final AtomicLong lastWriteTimeStamp = new AtomicLong(System.currentTimeMillis());

    /**
     * La última vez, en milisegundos, que ocurrió una operación de escritura.
     * @return esto
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp.get();
    }

    public void updateLastWriteTimeStamp() {
        lastWriteTimeStamp.set(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        LastWriteTimeStamp example = new LastWriteTimeStamp();
        System.out.println("Last write timestamp: " + example.lastWriteTimeStampInMilliseconds());
        example.updateLastWriteTimeStamp();
        System.out.println("Updated last write timestamp: " + example.lastWriteTimeStampInMilliseconds());
    }
}