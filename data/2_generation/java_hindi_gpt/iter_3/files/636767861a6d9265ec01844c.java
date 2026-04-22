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
     */
    public void removeAppender(String name) {
        Iterator<String> iterator = appenders.iterator();
        while (iterator.hasNext()) {
            String appender = iterator.next();
            if (appender.equals(name)) {
                iterator.remove();
                break; // Exit after removing the first matching appender
            }
        }
    }

    // Method to add appenders for testing purposes
    public void addAppender(String name) {
        appenders.add(name);
    }

    // Method to get the list of appenders for testing purposes
    public List<String> getAppenders() {
        return appenders;
    }

    public static void main(String[] args) {
        AppenderManager manager = new AppenderManager();
        manager.addAppender("ConsoleAppender");
        manager.addAppender("FileAppender");
        manager.addAppender("DatabaseAppender");

        System.out.println("Before removal: " + manager.getAppenders());
        manager.removeAppender("FileAppender");
        System.out.println("After removal: " + manager.getAppenders());
    }
}