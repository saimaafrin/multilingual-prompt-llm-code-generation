import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

public class PartialContentChecker {

    /**
     * Check if the actual response is a Partial Content (HTTP 206 code)
     * @param response the HTTP response to check
     * @return is partial content or not
     */
    public Boolean isPartialContentResponse(HttpResponse response) {
        if (response == null) {
            return false;
        }
        int statusCode = response.getStatusLine().getStatusCode();
        return statusCode == HttpStatus.SC_PARTIAL_CONTENT;
    }
}