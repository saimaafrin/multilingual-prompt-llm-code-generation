import java.util.HashMap;

public class MessagePrinter {
    private HashMap<String, Integer> messageTimestamps;

    public MessagePrinter() {
        messageTimestamps = new HashMap<>();
    }

    /** 
     * Returns true if the message should be printed in the given timestamp, otherwise returns false. 
     * If this method returns false, the message will not be printed. 
     * The timestamp is in seconds granularity. 
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message)) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        int lastTimestamp = messageTimestamps.get(message);
        if (timestamp - lastTimestamp >= 10) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        MessagePrinter printer = new MessagePrinter();
        System.out.println(printer.shouldPrintMessage(1, "Hello")); // true
        System.out.println(printer.shouldPrintMessage(2, "Hello")); // false
        System.out.println(printer.shouldPrintMessage(11, "Hello")); // true
    }
}