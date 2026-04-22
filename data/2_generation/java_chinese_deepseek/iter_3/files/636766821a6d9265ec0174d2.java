import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class AtmosphereRequestWrapper {

    public static AtmosphereRequest wrap(HttpServletRequest request) {
        // Create a new AtmosphereRequest.Builder using the provided HttpServletRequest
        AtmosphereRequest.Builder builder = AtmosphereRequest.wrap(request);

        // Build and return the AtmosphereRequest
        return builder.build();
    }
}