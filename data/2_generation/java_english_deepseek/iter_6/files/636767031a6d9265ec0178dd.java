import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    /**
     * Retrieve the content length of the request.
     * @param request The HttpServletRequest object.
     * @return The content length of the request.
     * @since 1.3
     */
    public static long contentLength(HttpServletRequest request) {
        return request.getContentLength();
    }
}