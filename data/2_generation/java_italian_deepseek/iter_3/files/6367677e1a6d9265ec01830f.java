import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * Produce una stringa formattata come specificato dal modello di conversione.
     * 
     * @param event L'evento di log da formattare.
     * @return La stringa formattata.
     */
    public String format(LoggingEvent event) {
        // Esempio di formattazione: [timestamp] [livello] messaggio
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        String level = event.getLevel().toString();
        String message = event.getMessage().toString();

        return String.format("[%s] [%s] %s", timestamp, level, message);
    }
}

// Classe di esempio per LoggingEvent
class LoggingEvent {
    private long timeStamp;
    private Level level;
    private Object message;

    public LoggingEvent(long timeStamp, Level level, Object message) {
        this.timeStamp = timeStamp;
        this.level = level;
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public Level getLevel() {
        return level;
    }

    public Object getMessage() {
        return message;
    }
}

// Enumerazione di esempio per i livelli di log
enum Level {
    INFO, WARN, ERROR, DEBUG
}