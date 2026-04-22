import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereConfig;

public class RequestWrapper {

    /**
     * Wrap an {@link HttpServletRequest}.
     * @param request {@link HttpServletRequest}
     * @return an {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        if (request instanceof AtmosphereRequest) {
            return (AtmosphereRequest) request;
        }

        return new AtmosphereRequest.Builder()
                .request(request)
                .build();
    }
}