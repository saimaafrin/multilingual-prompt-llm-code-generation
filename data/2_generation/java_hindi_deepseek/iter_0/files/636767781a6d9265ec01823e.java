import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class CustomAppender extends AppenderSkeleton {
    private List<String> connectedClients = new ArrayList<>();

    /** 
     * एक लॉग इवेंट को संभालता है। इस ऐपेंडर के लिए, इसका मतलब है कि संदेश को प्रत्येक जुड़े हुए क्लाइंट को लिखना।  
     */
    @Override
    protected void append(LoggingEvent event) {
        String message = layout.format(event);
        for (String client : connectedClients) {
            writeToClient(client, message);
        }
    }

    private void writeToClient(String client, String message) {
        // यहां क्लाइंट को संदेश लिखने का तरीका लागू करें
        System.out.println("Writing to client " + client + ": " + message);
    }

    public void addClient(String client) {
        connectedClients.add(client);
    }

    public void removeClient(String client) {
        connectedClients.remove(client);
    }

    @Override
    public void close() {
        // कोई संसाधन साफ करने की आवश्यकता हो तो यहां लागू करें
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}