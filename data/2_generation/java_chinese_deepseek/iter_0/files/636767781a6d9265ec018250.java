import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // 这里假设我们有一个字符串匹配的逻辑
        // 如果没有匹配到，返回 Filter.NEUTRAL
        // 你可以根据实际需求实现匹配逻辑
        if (!matches(event.getMessage().toString())) {
            return Filter.NEUTRAL;
        }
        // 如果有匹配，返回其他值，例如 Filter.ACCEPT 或 Filter.DENY
        return Filter.ACCEPT;
    }

    private boolean matches(String message) {
        // 实现你的字符串匹配逻辑
        // 这里只是一个示例，假设我们匹配包含 "error" 的字符串
        return message.contains("error");
    }
}