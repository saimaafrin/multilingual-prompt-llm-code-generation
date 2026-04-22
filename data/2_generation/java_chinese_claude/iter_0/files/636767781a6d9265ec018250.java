import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class LogFilter extends Filter {

    /**
     * 如果没有字符串匹配，则返回 {@link Filter#NEUTRAL}。
     */
    public int decide(LoggingEvent event) {
        if (event == null || event.getMessage() == null) {
            return Filter.NEUTRAL;
        }

        String message = event.getMessage().toString();
        
        // Since no specific matching criteria is provided in the docstring,
        // we return NEUTRAL as specified
        return Filter.NEUTRAL;
    }
}