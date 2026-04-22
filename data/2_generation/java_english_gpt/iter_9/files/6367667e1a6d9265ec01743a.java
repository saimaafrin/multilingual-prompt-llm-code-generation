public class WriteOperationTracker {
    private long lastWriteTimeStamp;

    /** 
     * The last time, in milliseconds, a write operation occurred.
     * @return this
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp;
    }

    public void writeOperation() {
        // Simulate a write operation
        lastWriteTimeStamp = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        WriteOperationTracker tracker = new WriteOperationTracker();
        tracker.writeOperation();
        System.out.println("Last write timestamp: " + tracker.lastWriteTimeStampInMilliseconds() + " ms");
    }
}