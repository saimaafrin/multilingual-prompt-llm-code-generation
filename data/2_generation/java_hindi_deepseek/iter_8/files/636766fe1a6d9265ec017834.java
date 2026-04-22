import java.util.UUID;

public class SessionIdGenerator {
    /**
     * Generates a unique session ID.
     * 
     * @return A unique session ID as a String.
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(sessionId());
    }
}