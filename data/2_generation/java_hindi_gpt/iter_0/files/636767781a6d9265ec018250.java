import org.apache.log4j.spi.LoggingEvent;

public class FilterExample {

    public static final int NEUTRAL = 0;

    /**
     * यदि कोई स्ट्रिंग मेल नहीं खाता है तो {@link Filter#NEUTRAL} लौटाता है।
     */
    public int decide(LoggingEvent event) {
        // यहाँ पर लॉजिक जोड़े जो यह निर्धारित करता है कि क्या स्ट्रिंग मेल खाता है
        String message = event.getMessage().toString();
        
        // उदाहरण के लिए, हम एक निश्चित स्ट्रिंग की तुलना करेंगे
        String targetString = "target";

        if (!message.contains(targetString)) {
            return NEUTRAL;
        }

        // अन्य निर्णयों के लिए कोड यहाँ जोड़ें
        return 1; // उदाहरण के लिए, मेल खाने पर 1 लौटाएँ
    }

    public static void main(String[] args) {
        // परीक्षण के लिए एक उदाहरण लॉगिंग इवेंट बनाएँ
        LoggingEvent event = new LoggingEvent("logger", null, System.currentTimeMillis(), 0, "This is a test message", null);
        FilterExample filterExample = new FilterExample();
        int result = filterExample.decide(event);
        System.out.println("Decision: " + result);
    }
}