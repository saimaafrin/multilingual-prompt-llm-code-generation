import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // 这里假设我们有一个字符串匹配的逻辑
        // 如果没有匹配到，返回 Filter.NEUTRAL
        // 例如，假设我们检查日志消息是否包含某个关键字
        String message = event.getRenderedMessage();
        if (message != null && message.contains("keyword")) {
            return Filter.ACCEPT; // 如果匹配到关键字，接受日志
        } else {
            return Filter.NEUTRAL; // 如果没有匹配到，返回 NEUTRAL
        }
    }
}