import java.util.HashMap;
import java.util.Map;

public class MessagePrinter {
    private Map<String, Integer> messageTimestamps;

    public MessagePrinter() {
        messageTimestamps = new HashMap<>();
    }

    /** 
     * Devuelve "true" si el mensaje debe imprimirse en la tiempo dada, de lo contrario devuelve falso. 
     * Si este método devuelve falso, el mensaje no se imprimirá. El tiempo está en segundos. 
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