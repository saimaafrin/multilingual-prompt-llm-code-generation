public class WriteOperationTracker {
    private long lastWriteTimeStamp;

    public WriteOperationTracker() {
        this.lastWriteTimeStamp = System.currentTimeMillis();
    }

    /**
     * L'ultima volta, in millisecondi, in cui è avvenuta un'operazione di scrittura.
     * @return questo
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp;
    }

    public void performWriteOperation() {
        // Simulate a write operation
        lastWriteTimeStamp = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        WriteOperationTracker tracker = new WriteOperationTracker();
        System.out.println("Last write timestamp: " + tracker.lastWriteTimeStampInMilliseconds());
        tracker.performWriteOperation();
        System.out.println("Last write timestamp after write: " + tracker.lastWriteTimeStampInMilliseconds());
    }
}