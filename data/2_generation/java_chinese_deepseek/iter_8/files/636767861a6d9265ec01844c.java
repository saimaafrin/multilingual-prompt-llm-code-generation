import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Logger {
    private List<Appender> appenders;

    public Logger() {
        this.appenders = new ArrayList<>();
    }

    /**
     * 从附加器列表中移除指定名称的附加器。
     * @param name 要移除的附加器的名称
     */
    public void removeAppender(String name) {
        Iterator<Appender> iterator = appenders.iterator();
        while (iterator.hasNext()) {
            Appender appender = iterator.next();
            if (appender.getName().equals(name)) {
                iterator.remove();
                break;
            }
        }
    }

    // 假设 Appender 是一个包含 getName() 方法的类
    private static class Appender {
        private String name;

        public Appender(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}