import java.util.concurrent.atomic.AtomicLong;

public class LastWriteTimeStamp {
    private final AtomicLong lastWriteTimeStamp = new AtomicLong();

    /**
     * अंतिम बार, मिलीसेकंड में, एक लिखने की प्रक्रिया हुई थी।
     * @return यह
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp.get();
    }

    /**
     * लिखने की प्रक्रिया को अपडेट करें और वर्तमान समय को सेट करें।
     */
    public void updateWriteTimeStamp() {
        lastWriteTimeStamp.set(System.currentTimeMillis());
    }
}