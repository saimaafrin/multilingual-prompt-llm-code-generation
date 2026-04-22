import java.util.logging.Logger;

public class LoggerChecker {

    /**
     * 检查指定名称的日志记录器是否存在于层次结构中。如果存在，则返回其引用；否则返回 <code>null</code>。
     * @param name 要搜索的日志记录器的名称。
     * @return 日志记录器的引用，如果不存在则返回 <code>null</code>。
     */
    public Logger exists(String name) {
        Logger logger = Logger.getLogger(name);
        if (logger != null) {
            return logger;
        } else {
            return null;
        }
    }
}