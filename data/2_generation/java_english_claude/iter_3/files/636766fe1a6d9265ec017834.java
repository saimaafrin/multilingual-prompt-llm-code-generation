import java.util.UUID;

public class Session {
    /**
     * Session ID.
     * @return A randomly generated UUID as a String to serve as a unique session identifier
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }
}