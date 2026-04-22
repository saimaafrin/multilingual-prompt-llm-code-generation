import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class CustomAppender extends AppenderSkeleton {

    @Override
    protected void append(LoggingEvent event) {
        // यहाँ पर लॉग इवेंट को सभी जुड़े हुए क्लाइंट्स को भेजने की प्रक्रिया होगी
        String message = event.getRenderedMessage();
        // सभी जुड़े हुए क्लाइंट्स को संदेश भेजने का कोड यहाँ लिखें
        sendToClients(message);
    }

    private void sendToClients(String message) {
        // यह एक उदाहरण है, यहाँ पर आप अपने क्लाइंट्स को संदेश भेजने का कोड लिख सकते हैं
        System.out.println("Sending message to clients: " + message);
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