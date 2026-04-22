import org.apache.http.HttpStatus;

public class HttpResponseChecker {
    
    private int statusCode;
    
    public HttpResponseChecker(int statusCode) {
        this.statusCode = statusCode;
    }
    
    /**
     * Check if the actual response is a Partial Content (HTTP 206 code)
     * @return is partial content or not
     */
    public boolean isPartialContent() {
        return statusCode == HttpStatus.SC_PARTIAL_CONTENT;
    }
}