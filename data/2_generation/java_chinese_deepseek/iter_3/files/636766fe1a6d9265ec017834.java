import java.util.UUID;

public class SessionIdGenerator {
    /**
     * 生成一个唯一的会话 ID。
     * 
     * @return 返回一个唯一的会话 ID 字符串。
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(sessionId());
    }
}