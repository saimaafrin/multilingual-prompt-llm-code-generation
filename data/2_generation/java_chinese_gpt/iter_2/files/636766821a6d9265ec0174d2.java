import javax.servlet.http.HttpServletRequest;

public class AtmosphereRequest {
    private HttpServletRequest request;

    // Constructor to initialize the AtmosphereRequest with HttpServletRequest
    public AtmosphereRequest(HttpServletRequest request) {
        this.request = request;
    }

    // Additional methods can be added here to interact with the HttpServletRequest

    public HttpServletRequest getRequest() {
        return request;
    }

    // Other methods can be added as needed
}

public class RequestWrapper {
    /**
     * 包装一个 {@link HttpServletRequest}。
     * @param request {@link HttpServletRequest}
     * @return 一个 {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        return new AtmosphereRequest(request);
    }
}