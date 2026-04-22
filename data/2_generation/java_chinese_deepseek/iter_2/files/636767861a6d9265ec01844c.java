import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppenderManager {
    private List<String> appenders;

    public AppenderManager() {
        this.appenders = new ArrayList<>();
    }

    /**
     * 从附加器列表中移除指定名称的附加器。
     */
    public void removeAppender(String name) {
        Iterator<String> iterator = appenders.iterator();
        while (iterator.hasNext()) {
            String appender = iterator.next();
            if (appender.equals(name)) {
                iterator.remove();
                break;
            }
        }
    }

    // 示例用法
    public static void main(String[] args) {
        AppenderManager manager = new AppenderManager();
        manager.appenders.add("Appender1");
        manager.appenders.add("Appender2");
        manager.appenders.add("Appender3");

        System.out.println("Before removal: " + manager.appenders);
        manager.removeAppender("Appender2");
        System.out.println("After removal: " + manager.appenders);
    }
}