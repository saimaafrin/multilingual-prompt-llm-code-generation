import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
    
    /**
     * 将日志事件格式化为写入器。
     * @param event 要格式化的日志事件。
     */
    public String format(final LoggingEvent event) {
        if (event == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        
        // 添加时间戳
        Date timestamp = new Date(event.getTimeStamp());
        sb.append(DATE_FORMAT.format(timestamp));
        sb.append(" ");
        
        // 添加日志级别
        sb.append("[").append(event.getLevel().toString()).append("] ");
        
        // 添加线程名
        sb.append("[").append(event.getThreadName()).append("] ");
        
        // 添加logger名称
        sb.append(event.getLoggerName());
        sb.append(" - ");
        
        // 添加日志消息
        sb.append(event.getRenderedMessage());
        
        // 添加异常堆栈（如果存在）
        String[] throwableInfo = event.getThrowableStrRep();
        if (throwableInfo != null) {
            sb.append("\n");
            for (String line : throwableInfo) {
                sb.append(line).append("\n");
            }
        }
        
        // 添加换行符
        sb.append("\n");
        
        return sb.toString();
    }
}