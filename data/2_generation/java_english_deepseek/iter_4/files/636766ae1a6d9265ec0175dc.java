import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class PartialContentChecker {

    /**
     * Check if the actual response is a Partial Content (HTTP 206 code)
     * @return is partial content or not
     */
    public Boolean isPartialContentResponse() {
        try {
            // Example URL, replace with the actual URL you want to check
            URL url = new URL("http://example.com/resource");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_PARTIAL;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        PartialContentChecker checker = new PartialContentChecker();
        System.out.println("Is Partial Content: " + checker.isPartialContentResponse());
    }
}