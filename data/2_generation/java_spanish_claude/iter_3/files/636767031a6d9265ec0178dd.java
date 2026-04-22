import javax.servlet.http.HttpServletRequest;

public class RequestWrapper {
    private HttpServletRequest request;

    public RequestWrapper(HttpServletRequest request) {
        this.request = request;
    }

    /** 
     * Recupera la longitud del contenido de la solicitud.
     * @return La longitud del contenido de la solicitud.
     * @since 1.3
     */
    public long contentLength() {
        String contentLength = request.getHeader("Content-Length");
        if (contentLength != null) {
            try {
                return Long.parseLong(contentLength);
            } catch (NumberFormatException e) {
                return -1L;
            }
        }
        return -1L;
    }
}