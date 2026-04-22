import java.util.UUID;

public class Session {
    /**
     * ID de sesión.
     * @return String containing a random UUID as session ID
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }
}