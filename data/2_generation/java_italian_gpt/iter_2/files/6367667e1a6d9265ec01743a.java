public class TimestampManager {
    private long lastWriteTimeStamp;

    public TimestampManager() {
        this.lastWriteTimeStamp = System.currentTimeMillis();
    }

    /** 
     * L'ultima volta, in millisecondi, in cui è avvenuta un'operazione di scrittura.
     * @return questo
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp;
    }

    public void writeOperation() {
        // Simulate a write operation
        lastWriteTimeStamp = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        TimestampManager manager = new TimestampManager();
        System.out.println("Last write timestamp: " + manager.lastWriteTimeStampInMilliseconds());
        manager.writeOperation();
        System.out.println("Updated write timestamp: " + manager.lastWriteTimeStampInMilliseconds());
    }
}