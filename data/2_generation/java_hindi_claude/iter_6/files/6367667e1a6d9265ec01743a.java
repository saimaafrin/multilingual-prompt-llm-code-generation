import java.time.Instant;

public class WriteTracker {
    private long lastWriteTime;

    public WriteTracker recordWriteTime() {
        this.lastWriteTime = Instant.now().toEpochMilli();
        return this;
    }
}