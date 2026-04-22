import java.util.HashMap;
import java.util.Map;

public class MessageLogger {
    private Map<String, Integer> messageTimestamps;

    public MessageLogger() {
        messageTimestamps = new HashMap<>();
    }

    /**
     * यदि संदेश को दिए गए टाइमस्टैम्प में प्रिंट किया जाना चाहिए, तो true लौटाता है, अन्यथा false लौटाता है।
     * यदि यह विधि false लौटाती है, तो संदेश प्रिंट नहीं किया जाएगा। टाइमस्टैम्प सेकंड की ग्रैन्युलैरिटी में है।
     *
     * @param timestamp वर्तमान टाइमस्टैम्प (सेकंड में)
     * @param message   संदेश जिसे प्रिंट किया जाना है
     * @return true यदि संदेश प्रिंट किया जाना चाहिए, अन्यथा false
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messageTimestamps.containsKey(message)) {
            int lastTimestamp = messageTimestamps.get(message);
            if (timestamp - lastTimestamp >= 10) {
                messageTimestamps.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            messageTimestamps.put(message, timestamp);
            return true;
        }
    }

    public static void main(String[] args) {
        MessageLogger logger = new MessageLogger();
        System.out.println(logger.shouldPrintMessage(1, "foo")); // true
        System.out.println(logger.shouldPrintMessage(2, "bar")); // true
        System.out.println(logger.shouldPrintMessage(3, "foo")); // false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // true
    }
}