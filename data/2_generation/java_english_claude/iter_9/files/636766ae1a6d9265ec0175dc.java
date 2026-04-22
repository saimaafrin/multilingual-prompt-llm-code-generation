import org.springframework.http.HttpStatus;

public class HttpResponseChecker {
    
    private HttpStatus responseStatus;
    
    public HttpResponseChecker(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
    
    /** 
     * Check if the actual response is a Partial Content (HTTP 206 code)
     * @return is partial content or not
     */
    public Boolean isPartialContentResponse() {
        return HttpStatus.PARTIAL_CONTENT.equals(responseStatus);
    }
}