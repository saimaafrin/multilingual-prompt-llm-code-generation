import java.util.UUID;

public class Session {
    /**
     * ID de sesión.
     * @return String containing a unique session ID using UUID
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }
}