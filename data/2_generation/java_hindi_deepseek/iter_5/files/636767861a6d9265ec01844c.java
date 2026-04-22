import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppenderManager {
    private List<String> appenders;

    public AppenderManager() {
        this.appenders = new ArrayList<>();
    }

    /**
     * पैरामीटर के रूप में दिए गए नाम के साथ एपेंडर को एपेंडर्स की सूची से हटा दें।
     * @param name एपेंडर का नाम जिसे हटाना है
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

    // Optional: Method to add appenders for testing
    public void addAppender(String name) {
        appenders.add(name);
    }

    // Optional: Method to get appenders for testing
    public List<String> getAppenders() {
        return appenders;
    }

    public static void main(String[] args) {
        AppenderManager manager = new AppenderManager();
        manager.addAppender("Appender1");
        manager.addAppender("Appender2");
        manager.addAppender("Appender3");

        System.out.println("Before removal: " + manager.getAppenders());
        manager.removeAppender("Appender2");
        System.out.println("After removal: " + manager.getAppenders());
    }
}