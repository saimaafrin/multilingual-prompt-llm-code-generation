public class WriteOperationTracker {
    private long lastWriteTimeStamp;

    public WriteOperationTracker() {
        this.lastWriteTimeStamp = System.currentTimeMillis();
    }

    /**
     * La última vez, en milisegundos, que ocurrió una operación de escritura.
     * @return esto
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
        tracker.performWriteOperation();
        System.out.println("Last write timestamp: " + tracker.lastWriteTimeStampInMilliseconds() + " ms");
    }
}