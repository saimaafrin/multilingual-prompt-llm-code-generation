import javax.servlet.http.HttpServletRequest;

public class RequestWrapper {
    private HttpServletRequest request;

    /**
     * Recupera la longitud del contenido de la solicitud.
     * @return La longitud del contenido de la solicitud.
     * @since 1.3
     */
    public long contentLength() {
        return request.getContentLength();
    }
}