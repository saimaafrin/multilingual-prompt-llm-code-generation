import javax.servlet.http.HttpServletRequest;

public class RequestHandler {
    private HttpServletRequest request;

    public RequestHandler(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Retrieve the content length of the request.
     * @return The content length of the request.
     * @since 1.3
     */
    public int getContentLength() {
        return request.getContentLength();
    }
}