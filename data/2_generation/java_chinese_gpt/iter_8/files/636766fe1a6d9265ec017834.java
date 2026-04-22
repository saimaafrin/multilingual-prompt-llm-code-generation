import java.util.UUID;

public class SessionUtil {
    /** 
     * 会话 ID。 
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println("Generated Session ID: " + sessionId());
    }
}