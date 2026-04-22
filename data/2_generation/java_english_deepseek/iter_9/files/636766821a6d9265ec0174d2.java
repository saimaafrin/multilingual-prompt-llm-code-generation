import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class RequestWrapper {

    /**
     * Wrap an {@link HttpServletRequest}.
     * @param request {@link HttpServletRequest}
     * @return an {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        // Create an AtmosphereRequest.Builder from the HttpServletRequest
        AtmosphereRequest.Builder builder = AtmosphereRequest.wrap(request);

        // Build and return the AtmosphereRequest
        return builder.build();
    }
}