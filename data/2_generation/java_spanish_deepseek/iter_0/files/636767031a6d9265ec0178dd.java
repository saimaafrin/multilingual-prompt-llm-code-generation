import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    private URL url;

    public HttpRequest(URL url) {
        this.url = url;
    }

    /**
     * Recupera la longitud del contenido de la solicitud.
     * @return La longitud del contenido de la solicitud.
     * @since 1.3
     */
    public long contentLength() {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            return connection.getContentLengthLong();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");
            HttpRequest request = new HttpRequest(url);
            long length = request.contentLength();
            System.out.println("Content Length: " + length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}