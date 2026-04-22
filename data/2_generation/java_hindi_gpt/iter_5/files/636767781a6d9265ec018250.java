import org.apache.log4j.spi.LoggingEvent;

public class Filter {
    public static final int NEUTRAL = 0;

    /**
     * यदि कोई स्ट्रिंग मेल नहीं खाता है तो {@link Filter#NEUTRAL} लौटाता है।
     */
    public int decide(LoggingEvent event) {
        // यहाँ पर लॉजिक जोड़े जो यह निर्धारित करता है कि क्या कोई स्ट्रिंग मेल खाता है
        // उदाहरण के लिए, हम एक सरल चेक कर सकते हैं
        String message = event.getMessage().toString();
        
        // मान लीजिए कि हम "ERROR" शब्द की तलाश कर रहे हैं
        if (message.contains("ERROR")) {
            return 1; // मेल खाता है
        } else {
            return NEUTRAL; // मेल नहीं खाता
        }
    }
}