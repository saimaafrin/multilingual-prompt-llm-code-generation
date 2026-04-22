import java.util.concurrent.atomic.AtomicLong;

public class TimeStampTracker {
    private final AtomicLong lastWriteTimeStamp = new AtomicLong(0);
    
    /**
     * 上一次写操作发生的时间，单位为毫秒。
     * @return this
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp.get();
    }
    
    // Helper method to update timestamp
    public void recordWrite() {
        lastWriteTimeStamp.set(System.currentTimeMillis());
    }
}