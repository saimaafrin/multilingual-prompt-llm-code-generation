import javax.servlet.http.HttpServletRequest;

public class RequestWrapper {
    private HttpServletRequest request;

    /**
     * Retrieve the content length of the request.
     * @return The content length of the request.
     * @since 1.3
     */
    public long contentLength() {
        long length = request.getContentLengthLong();
        if (length < 0) {
            // If content length header not set, return 0
            return 0L; 
        }
        return length;
    }
}