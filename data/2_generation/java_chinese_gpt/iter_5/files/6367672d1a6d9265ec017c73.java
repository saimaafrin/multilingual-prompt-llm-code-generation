import java.util.HashMap;

public class MessagePrinter {
    private HashMap<String, Integer> messageTimestamps;

    public MessagePrinter() {
        messageTimestamps = new HashMap<>();
    }

    /** 
     * 如果在给定的时间戳下应该打印消息，则返回真，否则返回假。如果此方法返回假，则消息将不会被打印。时间戳的粒度为秒。
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
        System.out.println(printer.shouldPrintMessage(1, "foo")); // true
        System.out.println(printer.shouldPrintMessage(2, "bar")); // true
        System.out.println(printer.shouldPrintMessage(3, "foo")); // false
        System.out.println(printer.shouldPrintMessage(8, "bar")); // false
        System.out.println(printer.shouldPrintMessage(10, "foo")); // false
        System.out.println(printer.shouldPrintMessage(11, "foo")); // true
    }
}