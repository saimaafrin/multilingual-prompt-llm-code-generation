import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Implementación de la lógica de filtrado
        // Aquí puedes agregar la lógica para decidir si el evento debe ser aceptado, rechazado o neutral
        // Por ejemplo, si no hay coincidencia de cadena, devolvemos NEUTRAL
        return Filter.NEUTRAL;
    }
}