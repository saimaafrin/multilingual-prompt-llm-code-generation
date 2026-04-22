import javax.servlet.http.HttpServletRequest;

public class RequestContentLength {

    private HttpServletRequest request;

    public RequestContentLength(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Recupera la lunghezza del contenuto della richiesta.
     * @return La lunghezza del contenuto della richiesta.
     * @since 1.3
     */
    public long contentLength() {
        return request.getContentLengthLong();
    }
}