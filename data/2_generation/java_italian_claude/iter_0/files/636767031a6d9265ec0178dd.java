import javax.servlet.http.HttpServletRequest;

public class RequestWrapper {
    private HttpServletRequest request;

    /**
     * Recupera la lunghezza del contenuto della richiesta.
     * @return La lunghezza del contenuto della richiesta.
     * @since 1.3
     */
    public long contentLength() {
        long length = request.getContentLengthLong();
        if (length < 0) {
            // If content length header not set, try to get actual content length
            try {
                length = request.getInputStream().available();
            } catch (Exception e) {
                length = -1L;
            }
        }
        return length;
    }
}