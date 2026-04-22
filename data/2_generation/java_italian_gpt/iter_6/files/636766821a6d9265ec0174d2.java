import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class RequestWrapper {

    /** 
     * Fornisce un {@link HttpServletRequest}.
     * @param request {@link HttpServletRequest}
     * @return un {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        return new AtmosphereRequest(request);
    }
}