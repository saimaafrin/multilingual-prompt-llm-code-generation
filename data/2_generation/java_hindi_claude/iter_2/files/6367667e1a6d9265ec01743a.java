import java.time.Instant;

public class WriteTracker {
    private long lastWriteTime;

    /**
     * The last time, in milliseconds, a write operation occurred.
     * @return this
     */
    public WriteTracker recordWriteTime() {
        this.lastWriteTime = Instant.now().toEpochMilli();
        return this;
    }
}