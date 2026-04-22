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
            URL url = new URL("https://example.com"); // Replace with your URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getContentLengthLong();
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // Return -1 in case of an error
        }
    }

    public static void main(String[] args) {
        ContentLengthChecker checker = new ContentLengthChecker();
        long length = checker.contentLength();
        System.out.println("Content Length: " + length);
    }
}