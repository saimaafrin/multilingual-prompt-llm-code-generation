import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class RequestWrapper {

    /** 
     * Fornisce un {@link HttpServletRequest}.
     * @param request {@link HttpServletRequest}
     * @return un {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        // Create a new AtmosphereRequest using the provided HttpServletRequest
        AtmosphereRequest atmosphereRequest = new AtmosphereRequest();
        
        // Set the necessary attributes from HttpServletRequest to AtmosphereRequest
        atmosphereRequest.setRequest(request);
        
        // Return the wrapped AtmosphereRequest
        return atmosphereRequest;
    }
}