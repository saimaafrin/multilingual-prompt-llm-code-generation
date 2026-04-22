import java.util.concurrent.atomic.AtomicLong;

public class WriteTimestamp {
    private final AtomicLong lastWriteTimestamp = new AtomicLong(0);

    /**
     * अंतिम बार, मिलीसेकंड में, एक लिखने की प्रक्रिया हुई थी।
     * @return यह
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimestamp.get();
    }

    // Example method to update the timestamp
    public void updateWriteTimestamp() {
        lastWriteTimestamp.set(System.currentTimeMillis());
    }
}