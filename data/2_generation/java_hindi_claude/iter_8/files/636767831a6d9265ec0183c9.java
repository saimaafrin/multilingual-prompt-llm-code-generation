import org.slf4j.MDC;

public class NDCUtil {
    /**
     * Looks at the last diagnostic context at the top of this NDC without removing it. <p>The returned value is the value 
     * that was pushed last. If no context is available, then the empty string "" is returned.
     * @return String The innermost diagnostic context.
     */
    public static String peek() {
        String value = MDC.get("NDC");
        if (value == null) {
            return "";
        }
        String[] contexts = value.split(" ");
        if (contexts.length == 0) {
            return "";
        }
        return contexts[contexts.length - 1];
    }
}