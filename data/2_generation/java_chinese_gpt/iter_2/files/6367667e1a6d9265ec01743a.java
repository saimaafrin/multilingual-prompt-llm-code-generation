public class Example {
    private long lastWriteTimeStamp;

    public Example() {
        this.lastWriteTimeStamp = System.currentTimeMillis();
    }

    /** 
     * 上一次写操作发生的时间，单位为毫秒。
     * @return this
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp;
    }

    public void writeData() {
        // Simulate a write operation
        lastWriteTimeStamp = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.writeData();
        System.out.println("Last write timestamp: " + example.lastWriteTimeStampInMilliseconds() + " ms");
    }
}