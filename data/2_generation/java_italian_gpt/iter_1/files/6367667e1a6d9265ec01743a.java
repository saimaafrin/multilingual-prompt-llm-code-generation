public class TimestampManager {
    private long lastWriteTime;

    /** 
     * L'ultima volta, in millisecondi, in cui è avvenuta un'operazione di scrittura.
     * @return questo
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTime;
    }

    public void writeOperation() {
        // Simulate a write operation
        lastWriteTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        TimestampManager manager = new TimestampManager();
        manager.writeOperation();
        System.out.println("Last write timestamp: " + manager.lastWriteTimeStampInMilliseconds() + " ms");
    }
}