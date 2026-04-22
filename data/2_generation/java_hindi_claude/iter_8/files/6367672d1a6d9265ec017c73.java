class Logger {
    private Map<String, Integer> messageTimestamps;
    private static final int RATE_LIMIT_SECONDS = 10;
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message)) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        int lastPrintTime = messageTimestamps.get(message);
        if (timestamp - lastPrintTime >= RATE_LIMIT_SECONDS) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}