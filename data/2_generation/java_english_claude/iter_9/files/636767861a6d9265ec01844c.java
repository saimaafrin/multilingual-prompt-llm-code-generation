import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Logger {
    private List<Appender> appenders;
    
    public Logger() {
        appenders = new ArrayList<>();
    }
    
    /**
     * Remove the appender with the name passed as parameter form the list of appenders.
     */
    public void removeAppender(String name) {
        if (name == null) {
            return;
        }
        
        Iterator<Appender> iterator = appenders.iterator();
        while (iterator.hasNext()) {
            Appender appender = iterator.next();
            if (name.equals(appender.getName())) {
                iterator.remove();
                break;
            }
        }
    }
    
    // Inner class representing an Appender
    private class Appender {
        private String name;
        
        public Appender(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
    }
}