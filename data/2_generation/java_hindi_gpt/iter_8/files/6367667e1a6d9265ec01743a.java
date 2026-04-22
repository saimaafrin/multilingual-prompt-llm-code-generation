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

    public void updateWriteTime() {
        lastWriteTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        WriteTimeTracker tracker = new WriteTimeTracker();
        System.out.println("Last write timestamp: " + tracker.lastWriteTimeStampInMilliseconds() + " ms");
        
        // Simulate a write operation
        tracker.updateWriteTime();
        System.out.println("Updated write timestamp: " + tracker.lastWriteTimeStampInMilliseconds() + " ms");
    }
}