import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppenderManager {
    private List<String> appenders;

    public AppenderManager() {
        this.appenders = new ArrayList<>();
    }

    /**
     * Elimina el "appender" con el nombre pasado como parámetro de la lista de "appenders".  
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
}