import org.apache.log4j.spi.LoggingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * 根据转换模式生成格式化字符串。
     * @param event 日志事件
     * @return 格式化后的日志字符串
     */
    public String format(LoggingEvent event) {
        // 获取日志级别
        String level = event.getLevel().toString();
        // 获取日志时间
        long timeStamp = event.getTimeStamp();
        Date date = new Date(timeStamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        // 获取日志消息
        String message = event.getMessage().toString();
        // 获取日志线程名
        String threadName = event.getThreadName();
        // 获取日志类名
        String className = event.getLocationInformation().getClassName();
        // 获取日志方法名
        String methodName = event.getLocationInformation().getMethodName();
        // 获取日志行号
        String lineNumber = event.getLocationInformation().getLineNumber();

        // 格式化日志输出
        return String.format("[%s] %s [%s] %s.%s:%s - %s",
                level, formattedDate, threadName, className, methodName, lineNumber, message);
    }
}