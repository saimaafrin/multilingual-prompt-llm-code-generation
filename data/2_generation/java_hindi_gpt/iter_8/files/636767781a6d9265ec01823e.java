import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class CustomAppender extends AppenderSkeleton {

    @Override
    protected void append(LoggingEvent event) {
        // यहाँ पर लॉग इवेंट को सभी जुड़े हुए क्लाइंट्स को भेजने की प्रक्रिया होगी
        String message = event.getRenderedMessage();
        // सभी जुड़े हुए क्लाइंट्स को संदेश भेजने के लिए कस्टम लॉजिक यहाँ लागू करें
        sendToClients(message);
    }

    private void sendToClients(String message) {
        // कस्टम लॉजिक जो सभी जुड़े हुए क्लाइंट्स को संदेश भेजता है
        // उदाहरण के लिए, WebSocket या अन्य नेटवर्किंग तकनीक का उपयोग कर सकते हैं
        System.out.println("Sending message to clients: " + message);
    }

    @Override
    public void close() {
        // क्लोज़िंग लॉजिक यहाँ
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}