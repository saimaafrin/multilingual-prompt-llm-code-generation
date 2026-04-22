public class WriteTimeTracker {
    private long lastWriteTimeStamp;

    /**
     * The last time, in milliseconds, a write operation occurred.
     * @return this
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp;
    }

    /**
     * Updates the last write timestamp to the current time in milliseconds.
     */
    public void updateWriteTimeStamp() {
        this.lastWriteTimeStamp = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        WriteTimeTracker tracker = new WriteTimeTracker();
        tracker.updateWriteTimeStamp();
        System.out.println("Last write timestamp: " + tracker.lastWriteTimeStampInMilliseconds());
    }
}