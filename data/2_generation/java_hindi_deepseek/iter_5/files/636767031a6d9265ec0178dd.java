import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ContentLengthChecker {

    /**
     * अनुरोध की सामग्री की लंबाई प्राप्त करें।
     * @return अनुरोध की सामग्री की लंबाई।
     * @since 1.3
     */
    public long contentLength() {
        try {
            // Replace with the actual URL you want to check
            URL url = new URL("https://example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            return connection.getContentLengthLong();
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // Return -1 if there's an error
        }
    }

    public static void main(String[] args) {
        ContentLengthChecker checker = new ContentLengthChecker();
        long length = checker.contentLength();
        System.out.println("Content Length: " + length);
    }
}