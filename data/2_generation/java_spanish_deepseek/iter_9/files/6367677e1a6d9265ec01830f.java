import org.apache.log4j.spi.LoggingEvent;

public class LogFormatter {

    public String format(LoggingEvent event) {
        // Ejemplo de formato: [Nivel] Mensaje - Hora
        String level = event.getLevel().toString();
        String message = event.getRenderedMessage();
        long timeStamp = event.getTimeStamp();
        
        // Formatear la hora en un formato legible
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = dateFormat.format(new java.util.Date(timeStamp));
        
        // Construir la cadena formateada
        return String.format("[%s] %s - %s", level, message, formattedTime);
    }
}