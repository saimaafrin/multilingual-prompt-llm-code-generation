import java.util.concurrent.atomic.AtomicLong;

public class LastWriteTimeStamp {
    private final AtomicLong lastWriteTimeStamp = new AtomicLong(System.currentTimeMillis());

    /**
     * अंतिम बार, मिलीसेकंड में, एक लिखने की प्रक्रिया हुई थी।
     * @return यह
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp.get();
    }

    public void updateLastWriteTimeStamp() {
        lastWriteTimeStamp.set(System.currentTimeMillis());
    }
}