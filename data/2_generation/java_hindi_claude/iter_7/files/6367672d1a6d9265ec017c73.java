class Logger {
    private Map<String, Integer> messageMap;
    private static final int RATE_LIMIT = 10; // 10 seconds

    public Logger() {
        messageMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageMap.containsKey(message)) {
            messageMap.put(message, timestamp);
            return true;
        }
        
        int lastPrinted = messageMap.get(message);
        if (timestamp - lastPrinted >= RATE_LIMIT) {
            messageMap.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}