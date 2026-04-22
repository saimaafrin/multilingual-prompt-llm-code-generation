import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    private URL url;

    public HttpRequest(URL url) {
        this.url = url;
    }

    /**
     * 获取请求的内容长度。
     * @return 请求的内容长度。
     * @since 1.3
     */
    public long contentLength() {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            return connection.getContentLengthLong();
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // 返回-1表示获取失败
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