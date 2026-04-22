import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppenderManager {
    private List<String> appenders;

    public AppenderManager() {
        this.appenders = new ArrayList<>();
    }

    /**
     * Remove the appender with the name passed as parameter from the list of appenders.  
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
        System.out.println("Before removal: " + manager.getAppenders());
        manager.removeAppender("ConsoleAppender");
        System.out.println("After removal: " + manager.getAppenders());
    }
}