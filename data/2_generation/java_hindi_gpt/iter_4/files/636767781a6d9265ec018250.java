import org.apache.log4j.spi.LoggingEvent;

public class Filter {
    public static final int NEUTRAL = 0;

    /**
     * यदि कोई स्ट्रिंग मेल नहीं खाता है तो {@link Filter#NEUTRAL} लौटाता है।
     */
    public int decide(LoggingEvent event) {
        // यहाँ पर लॉजिक जोड़े जो यह निर्धारित करता है कि क्या कोई स्ट्रिंग मेल खाता है
        // उदाहरण के लिए, हम मान लेते हैं कि हम एक विशेष स्ट्रिंग की जांच कर रहे हैं
        String message = event.getMessage().toString();
        String targetString = "target"; // यहाँ पर लक्षित स्ट्रिंग डालें

        if (!message.contains(targetString)) {
            return NEUTRAL;
        }

        // यदि मेल खाता है तो कुछ और लौटाएँ (उदाहरण के लिए, 1)
        return 1; // या कोई अन्य मान जो मेल खाने पर लौटाना हो
    }
}