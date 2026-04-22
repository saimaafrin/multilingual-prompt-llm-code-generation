import java.net.HttpURLConnection;
import java.net.URL;

public class PartialContentChecker {

    /**
     * 检查实际响应是否为部分内容（HTTP 206 代码）
     * @return 是否为部分内容
     */
    public Boolean isPartialContentResponse() {
        try {
            // 假设我们有一个URL对象
            URL url = new URL("http://example.com/resource");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_PARTIAL;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        PartialContentChecker checker = new PartialContentChecker();
        System.out.println("Is partial content response: " + checker.isPartialContentResponse());
    }
}