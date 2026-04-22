import java.time.Instant;

public class TimeStampTracker {
    private long lastWriteTimeStamp;

    public TimeStampTracker() {
        this.lastWriteTimeStamp = Instant.now().toEpochMilli();
    }

    /** 
     * L'ultima volta, in millisecondi, in cui è avvenuta un'operazione di scrittura.
     * @return questo
     */
    public long lastWriteTimeStampInMilliseconds() {
        return this.lastWriteTimeStamp;
    }
}