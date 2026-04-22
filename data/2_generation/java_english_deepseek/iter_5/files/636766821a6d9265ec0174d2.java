import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class RequestWrapper {

    /**
     * Wrap an {@link HttpServletRequest}.
     * @param request {@link HttpServletRequest}
     * @return an {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("HttpServletRequest cannot be null");
        }
        return AtmosphereRequest.wrap(request);
    }
}