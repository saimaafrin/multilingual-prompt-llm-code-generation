import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class CustomAppender extends AppenderSkeleton {

    @Override
    protected void append(LoggingEvent event) {
        // यहाँ लॉग इवेंट को संभालने की प्रक्रिया है
        String message = event.getRenderedMessage();
        // सभी जुड़े हुए क्लाइंट्स को संदेश भेजने की प्रक्रिया
        sendToClients(message);
    }

    private void sendToClients(String message) {
        // यहाँ पर लॉग संदेश को सभी जुड़े हुए क्लाइंट्स को भेजने की प्रक्रिया को लागू करें
        System.out.println("Sending message to clients: " + message);
        // उदाहरण के लिए, आप सॉकेट्स या अन्य संचार विधियों का उपयोग कर सकते हैं
    }

    @Override
    public void close() {
        // क्लोज़ करने की प्रक्रिया
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}