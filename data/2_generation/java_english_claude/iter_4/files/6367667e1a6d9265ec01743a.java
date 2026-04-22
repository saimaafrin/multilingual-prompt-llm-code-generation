import java.time.Instant;

public class TimeTracker {
    private long lastWriteTimestamp;

    public long lastWriteTimeStampInMilliseconds() {
        lastWriteTimestamp = Instant.now().toEpochMilli();
        return lastWriteTimestamp;
    }
}