import javax.servlet.http.HttpServletRequest;

public class RequestContentLength {

    private HttpServletRequest request;

    public RequestContentLength(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Retrieve the content length of the request.
     * @return The content length of the request.
     * @since 1.3
     */
    public long contentLength() {
        return request.getContentLength();
    }
}