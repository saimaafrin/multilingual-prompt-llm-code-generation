import java.util.List;
import java.util.Iterator;

public class AppenderManager {
    private List<Appender> appenders;

    public AppenderManager(List<Appender> appenders) {
        this.appenders = appenders;
    }

    /** 
     * पैरामीटर के रूप में दिए गए नाम के साथ एपेंडर को एपेंडर्स की सूची से हटा दें।  
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