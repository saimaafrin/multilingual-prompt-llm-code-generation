import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogFormatter {
    
    private static final String DEFAULT_PATTERN = "[%d{yyyy-MM-dd HH:mm:ss}] [%p] %c - %m%n";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    /**
     * 根据转换模式生成格式化字符串。
     */
    public String format(LoggingEvent event) {
        if (event == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        
        // Add timestamp
        builder.append("[");
        builder.append(dateFormat.format(new Date(event.getTimeStamp())));
        builder.append("] ");
        
        // Add log level
        builder.append("[");
        builder.append(event.getLevel().toString());
        builder.append("] ");
        
        // Add logger name
        builder.append(event.getLoggerName());
        builder.append(" - ");
        
        // Add message
        builder.append(event.getRenderedMessage());
        
        // Add new line
        builder.append(System.lineSeparator());
        
        // Add throwable info if exists
        String[] throwableInfo = event.getThrowableStrRep();
        if (throwableInfo != null) {
            for (String line : throwableInfo) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
        }
        
        return builder.toString();
    }
}