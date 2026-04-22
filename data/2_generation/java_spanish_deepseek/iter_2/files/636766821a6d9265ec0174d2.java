import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class RequestWrapper {

    /**
     * Envuelve un {@link HttpServletRequest}.
     * @param request {@link HttpServletRequest}
     * @return un {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        // Create a new AtmosphereRequest.Builder using the provided HttpServletRequest
        AtmosphereRequest.Builder builder = new AtmosphereRequest.Builder();
        
        // Set the necessary properties from the HttpServletRequest to the AtmosphereRequest
        builder.request(request)
               .method(request.getMethod())
               .headers(request)
               .pathInfo(request.getPathInfo())
               .servletPath(request.getServletPath())
               .queryString(request.getQueryString())
               .contentType(request.getContentType())
               .characterEncoding(request.getCharacterEncoding())
               .remoteAddr(request.getRemoteAddr())
               .remoteHost(request.getRemoteHost())
               .remotePort(request.getRemotePort())
               .localAddr(request.getLocalAddr())
               .localName(request.getLocalName())
               .localPort(request.getLocalPort())
               .scheme(request.getScheme())
               .serverName(request.getServerName())
               .serverPort(request.getServerPort())
               .secure(request.isSecure());

        // Build and return the AtmosphereRequest
        return builder.build();
    }
}