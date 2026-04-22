public class WriteTracker {
    private long lastWriteTimeStamp;

    public WriteTracker() {
        this.lastWriteTimeStamp = System.currentTimeMillis();
    }

    /**
     * The last time, in milliseconds, a write operation occurred.
     * @return this
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp;
    }

    public void recordWriteOperation() {
        this.lastWriteTimeStamp = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        WriteTracker tracker = new WriteTracker();
        System.out.println("Initial timestamp: " + tracker.lastWriteTimeStampInMilliseconds());

        // Simulate a write operation
        try {
            Thread.sleep(1000); // Simulate a delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tracker.recordWriteOperation();
        System.out.println("Updated timestamp: " + tracker.lastWriteTimeStampInMilliseconds());
    }
}