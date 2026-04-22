import javax.servlet.http.HttpServletRequest;

public class AtmosphereRequestWrapper {

    /**
     * 包装一个 {@link HttpServletRequest}。
     * @param request {@link HttpServletRequest}
     * @return 一个 {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        // Assuming AtmosphereRequest has a constructor that takes HttpServletRequest
        return new AtmosphereRequest(request);
    }
}

// Assuming a simple AtmosphereRequest class for demonstration purposes
class AtmosphereRequest {
    private HttpServletRequest request;

    public AtmosphereRequest(HttpServletRequest request) {
        this.request = request;
    }

    // Additional methods to interact with the HttpServletRequest can be added here
}