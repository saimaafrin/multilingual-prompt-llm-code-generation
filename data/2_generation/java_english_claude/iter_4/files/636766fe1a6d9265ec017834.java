import java.util.UUID;

public class Session {
    /**
     * Session ID.
     * Generates a unique session identifier using UUID
     * @return String containing random UUID as session ID
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }
}