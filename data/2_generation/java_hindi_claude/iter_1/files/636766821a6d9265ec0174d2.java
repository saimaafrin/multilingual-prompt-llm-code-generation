import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereHandler;

public class RequestWrapper {

    public AtmosphereRequest wrapRequest(HttpServletRequest request) {
        return AtmosphereRequest.wrap(request);
    }

}