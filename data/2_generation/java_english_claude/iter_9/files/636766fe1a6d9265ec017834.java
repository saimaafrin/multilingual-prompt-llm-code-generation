import java.util.UUID;

public class Session {
    /**
     * Session ID.
     * @return A randomly generated UUID string to use as session ID
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }
}