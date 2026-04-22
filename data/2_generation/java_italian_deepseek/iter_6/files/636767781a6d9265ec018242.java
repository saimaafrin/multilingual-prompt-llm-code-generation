import org.apache.log4j.Appender;
import org.apache.log4j.spi.LoggingEvent;

public class Logger {

    private Appender[] appenders;

    public Logger(Appender[] appenders) {
        this.appenders = appenders;
    }

    /**
     * Chiama il metodo <code>doAppend</code> su tutti gli appender collegati.
     * @param event L'evento di log da appendere.
     * @return Il numero di appender su cui è stato chiamato il metodo <code>doAppend</code>.
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int count = 0;
        if (appenders != null) {
            for (Appender appender : appenders) {
                if (appender != null) {
                    appender.doAppend(event);
                    count++;
                }
            }
        }
        return count;
    }
}