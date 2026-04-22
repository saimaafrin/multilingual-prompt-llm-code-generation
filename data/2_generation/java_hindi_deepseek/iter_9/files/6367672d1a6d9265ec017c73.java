import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> messageTimestamps;

    public Logger() {
        messageTimestamps = new HashMap<>();
    }

    /**
     * यदि संदेश को दिए गए टाइमस्टैम्प में प्रिंट किया जाना चाहिए, तो true लौटाता है, अन्यथा false लौटाता है। यदि यह विधि false लौटाती है, तो संदेश प्रिंट नहीं किया जाएगा। टाइमस्टैम्प सेकंड की ग्रैन्युलैरिटी में है।
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
}