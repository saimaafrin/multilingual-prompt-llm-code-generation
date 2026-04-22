import java.util.UUID;

public class Session {
    /**
     * ID della sessione.
     * @return String containing a unique session ID
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }
}