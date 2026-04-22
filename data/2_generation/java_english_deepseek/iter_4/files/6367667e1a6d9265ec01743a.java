public class WriteTimeTracker {
    private long lastWriteTimeStamp;

    public WriteTimeTracker() {
        this.lastWriteTimeStamp = 0;
    }

    /**
     * The last time, in milliseconds, a write operation occurred.
     * @return this
     */
    public long lastWriteTimeStampInMilliseconds() {
        return this.lastWriteTimeStamp;
    }

    public void recordWriteOperation() {
        this.lastWriteTimeStamp = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        WriteTimeTracker tracker = new WriteTimeTracker();
        tracker.recordWriteOperation();
        System.out.println("Last write timestamp: " + tracker.lastWriteTimeStampInMilliseconds());
    }
}