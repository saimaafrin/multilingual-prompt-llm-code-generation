import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class RequestWrapper {

    /**
     * एक {@link HttpServletRequest} को लपेटें।
     * @param request {@link HttpServletRequest}
     * @return एक {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        // Create an AtmosphereRequest from the HttpServletRequest
        AtmosphereRequest atmosphereRequest = AtmosphereRequest.wrap(request);
        return atmosphereRequest;
    }
}