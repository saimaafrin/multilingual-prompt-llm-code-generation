public class WriteTimeTracker {
    
    private long lastWriteTime;

    public WriteTimeTracker() {
        this.lastWriteTime = System.currentTimeMillis();
    }

    /**
     * अंतिम बार, मिलीसेकंड में, एक लिखने की प्रक्रिया हुई थी।
     * @return यह
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTime;
    }

    public void writeData() {
        // Simulate a write operation
        lastWriteTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        WriteTimeTracker tracker = new WriteTimeTracker();
        tracker.writeData();
        System.out.println("Last write timestamp in milliseconds: " + tracker.lastWriteTimeStampInMilliseconds());
    }
}