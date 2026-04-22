import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class RequestWrapper {

    /** 
     * Wrap an  {@link HttpServletRequest}.
     * @param request {@link HttpServletRequest}
     * @return an {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        // Assuming AtmosphereRequest has a constructor that takes HttpServletRequest
        return new AtmosphereRequest(request);
    }
}