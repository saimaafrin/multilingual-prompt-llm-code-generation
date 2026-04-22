import org.apache.http.HttpStatus;

public class HttpResponseChecker {
    
    /**
     * Check if the actual response is a Partial Content (HTTP 206 code)
     * @return is partial content or not
     */
    public boolean isPartialContent() {
        return HttpStatus.SC_PARTIAL_CONTENT == 206;
    }
}