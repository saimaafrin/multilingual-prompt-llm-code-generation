import java.util.concurrent.atomic.AtomicLong;

public class LastWriteTimestamp {
    private final AtomicLong lastWriteTimestamp = new AtomicLong();

    /**
     * अंतिम बार, मिलीसेकंड में, एक लिखने की प्रक्रिया हुई थी।
     * @return यह
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimestamp.get();
    }

    /**
     * अंतिम लिखने की प्रक्रिया का समय अपडेट करें।
     * @param timestamp मिलीसेकंड में समय
     */
    public void updateLastWriteTimestamp(long timestamp) {
        lastWriteTimestamp.set(timestamp);
    }
}