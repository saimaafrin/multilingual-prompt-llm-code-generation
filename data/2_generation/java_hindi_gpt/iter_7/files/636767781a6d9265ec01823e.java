import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class CustomAppender extends AppenderSkeleton {

    @Override
    protected void append(LoggingEvent event) {
        // यहाँ पर लॉग इवेंट को सभी जुड़े हुए क्लाइंट्स को भेजने की प्रक्रिया होगी
        String message = event.getRenderedMessage();
        // सभी जुड़े हुए क्लाइंट्स को संदेश भेजने के लिए कोड यहाँ लिखें
        // उदाहरण के लिए, एक सॉकेट कनेक्शन का उपयोग करके संदेश भेजना
        System.out.println("Sending log message to clients: " + message);
    }

    @Override
    public void close() {
        // क्लोज़िंग संसाधनों की प्रक्रिया
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}