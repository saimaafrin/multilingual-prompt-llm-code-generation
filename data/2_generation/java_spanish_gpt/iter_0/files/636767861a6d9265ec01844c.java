import java.util.Iterator;
import java.util.List;

public class AppenderManager {
    private List<String> appenders;

    public AppenderManager(List<String> appenders) {
        this.appenders = appenders;
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
}