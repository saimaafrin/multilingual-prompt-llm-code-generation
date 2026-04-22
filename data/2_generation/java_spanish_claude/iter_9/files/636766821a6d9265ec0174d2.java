import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceImpl;

public class RequestWrapper {

    /** 
     * Envuelve un {@link HttpServletRequest}.
     * @param request {@link HttpServletRequest}
     * @return un {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        if (request instanceof AtmosphereRequest) {
            return (AtmosphereRequest) request;
        }

        return AtmosphereRequest.wrap(request);
    }
}