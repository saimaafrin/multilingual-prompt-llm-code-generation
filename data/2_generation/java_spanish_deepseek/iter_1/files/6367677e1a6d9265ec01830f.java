import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * Produce una cadena formateada según lo especificado por el patrón de conversión.
     * 
     * @param event El evento de registro que contiene la información a formatear.
     * @return Una cadena formateada según el patrón de conversión.
     */
    public String format(LoggingEvent event) {
        // Ejemplo de patrón de conversión: [fecha] [nivel] [mensaje]
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date(event.getTimeStamp()));
        
        return String.format("[%s] [%s] %s", formattedDate, event.getLevel(), event.getMessage());
    }
}

// Clase de ejemplo para LoggingEvent
class LoggingEvent {
    private long timeStamp;
    private String level;
    private String message;

    public LoggingEvent(long timeStamp, String level, String message) {
        this.timeStamp = timeStamp;
        this.level = level;
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}