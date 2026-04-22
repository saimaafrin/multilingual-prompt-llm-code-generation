import org.apache.log4j.Appender;
import org.apache.log4j.spi.LoggingEvent;

public class Logger {
    private Appender[] appenders;

    public Logger(Appender[] appenders) {
        this.appenders = appenders;
    }

    /**
     * Llama al método <code>doAppend</code> en todos los "appenders" adjuntos.
     * @param event El evento de logging que se va a enviar a los appenders.
     * @return El número de appenders a los que se les envió el evento.
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