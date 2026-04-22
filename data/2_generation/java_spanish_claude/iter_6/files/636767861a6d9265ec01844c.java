import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Logger {
    private List<Appender> appenders;
    
    public Logger() {
        appenders = new ArrayList<>();
    }
    
    /**
     * Elimina el "appender" con el nombre pasado como parámetro de la lista de "appenders".
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
    
    // Inner class to represent an Appender
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