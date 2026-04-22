import java.util.Iterator;
import java.util.List;

public class AppenderManager {
    private List<Appender> appenders;

    public AppenderManager(List<Appender> appenders) {
        this.appenders = appenders;
    }

    /** 
     * 从附加器列表中移除指定名称的附加器。
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
}

class Appender {
    private String name;

    public Appender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}