import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class AtmosphereRequestWrapper {

    /**
     * Fornisce un {@link HttpServletRequest}.
     * @param request {@link HttpServletRequest}
     * @return un {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        // Create an AtmosphereRequest from the HttpServletRequest
        AtmosphereRequest atmosphereRequest = AtmosphereRequest.wrap(request);
        return atmosphereRequest;
    }
}