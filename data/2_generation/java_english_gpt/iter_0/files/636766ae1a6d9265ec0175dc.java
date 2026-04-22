import java.net.HttpURLConnection;

public class HttpResponseChecker {

    private HttpURLConnection connection;

    public HttpResponseChecker(HttpURLConnection connection) {
        this.connection = connection;
    }

    /** 
     * Check if the actual response is a Partial Content (HTTP 206 code)
     * @return is partial content or not
     */
    public Boolean isPartialContentResponse() {
        try {
            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_PARTIAL; // 206
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}