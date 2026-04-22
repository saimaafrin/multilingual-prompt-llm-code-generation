import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    public String format(LoggingEvent event) {
        // Crear un objeto SimpleDateFormat para formatear la fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        // Obtener la fecha y formatearla
        String formattedDate = dateFormat.format(new Date(event.getTimeStamp()));
        
        // Formatear el mensaje de log
        String formattedMessage = String.format("[%s] %s: %s", 
            formattedDate, 
            event.getLevel().toString(), 
            event.getMessage());
        
        return formattedMessage;
    }
}

// Clase LoggingEvent simulada para el ejemplo
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