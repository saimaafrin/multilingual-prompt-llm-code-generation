import java.util.HashMap;

public class MessagePrinter {
    private HashMap<String, Integer> messageTimestamps;

    public MessagePrinter() {
        messageTimestamps = new HashMap<>();
    }

    /**
     * यदि संदेश को दिए गए टाइमस्टैम्प में प्रिंट किया जाना चाहिए, तो true लौटाता है, अन्यथा false लौटाता है। 
     * यदि यह विधि false लौटाती है, तो संदेश प्रिंट नहीं किया जाएगा। 
     * टाइमस्टैम्प सेकंड की ग्रैन्युलैरिटी में है। 
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
        System.out.println(printer.shouldPrintMessage(11, "foo")); // true
    }
}