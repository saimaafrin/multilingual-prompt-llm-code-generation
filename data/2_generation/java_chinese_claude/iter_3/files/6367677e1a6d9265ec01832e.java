import java.util.logging.Logger;

public class LoggerManager {
    /**
     * 检查指定名称的日志记录器是否存在于层次结构中。如果存在，则返回其引用；否则返回 <code>null</code>。
     * @param name 要搜索的日志记录器的名称。
     */
    public Logger exists(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        
        // Get the logger if it exists, without creating a new one
        return Logger.getLogger(name).getParent() == null ? null : Logger.getLogger(name);
    }
}