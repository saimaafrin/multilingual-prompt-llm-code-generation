import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Implementación de la lógica de filtrado
        // Aquí puedes agregar la lógica para decidir si el evento debe ser aceptado, rechazado o neutral
        // Por ejemplo, si el mensaje del evento contiene una cadena específica, puedes devolver Filter.ACCEPT o Filter.DENY
        // Si no hay coincidencia, devuelve Filter.NEUTRAL

        // Ejemplo básico:
        String message = event.getMessage().toString();
        if (message.contains("specific string")) {
            return Filter.ACCEPT;
        } else if (message.contains("another string")) {
            return Filter.DENY;
        } else {
            return Filter.NEUTRAL;
        }
    }
}