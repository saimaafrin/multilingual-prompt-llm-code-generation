import java.util.concurrent.atomic.AtomicLong;

public class WriteTimestamp {
    private final AtomicLong lastWriteTimestamp = new AtomicLong();

    /**
     * अंतिम बार, मिलीसेकंड में, एक लिखने की प्रक्रिया हुई थी।
     * @return यह
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimestamp.get();
    }

    /**
     * लिखने की प्रक्रिया के समय को अपडेट करें।
     * @param timestamp मिलीसेकंड में समय
     */
    public void updateWriteTimestamp(long timestamp) {
        lastWriteTimestamp.set(timestamp);
    }

    public static void main(String[] args) {
        WriteTimestamp writeTimestamp = new WriteTimestamp();
        writeTimestamp.updateWriteTimestamp(System.currentTimeMillis());
        System.out.println("Last write timestamp: " + writeTimestamp.lastWriteTimeStampInMilliseconds());
    }
}