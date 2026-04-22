import javax.servlet.http.HttpServletRequest;

public class RequestContentLength {

    private HttpServletRequest request;

    public RequestContentLength(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Recupera la longitud del contenido de la solicitud.
     * @return La longitud del contenido de la solicitud.
     * @since 1.3
     */
    public long contentLength() {
        return request.getContentLengthLong();
    }
}