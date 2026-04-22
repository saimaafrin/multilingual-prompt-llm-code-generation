import java.util.UUID;

public class SessionIdGenerator {
    /** 
     * सत्र आईडी। 
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println("Generated Session ID: " + sessionId());
    }
}