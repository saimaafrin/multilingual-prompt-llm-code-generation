import java.util.UUID;

public class SessionUtils {
    /**
     * 会话 ID。
     * @return 返回一个唯一的会话ID字符串
     */
    public static String sessionId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}