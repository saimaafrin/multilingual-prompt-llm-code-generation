import java.util.logging.Logger;

public class LoggerChecker {
    
    /**
     * 检查指定名称的日志记录器是否存在于层次结构中。如果存在，则返回其引用；否则返回 <code>null</code>。
     * @param name 要搜索的日志记录器的名称。
     */
    public Logger exists(String name) {
        Logger logger = Logger.getLogger(name);
        return logger.getHandlers().length > 0 ? logger : null;
    }

    public static void main(String[] args) {
        LoggerChecker checker = new LoggerChecker();
        Logger logger = checker.exists("myLogger");
        if (logger != null) {
            System.out.println("Logger exists: " + logger.getName());
        } else {
            System.out.println("Logger does not exist.");
        }
    }
}