import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class RequestWrapper {

    /**
     * 包装一个 {@link HttpServletRequest}。
     * @param request {@link HttpServletRequest}
     * @return 一个 {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        return AtmosphereRequest.wrap(request);
    }
}