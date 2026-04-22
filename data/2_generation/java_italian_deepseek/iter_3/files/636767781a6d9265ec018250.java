import org.apache.log4j.spi.LoggingEvent;

public class Filter {
    public static final int NEUTRAL = 0;

    public int decide(LoggingEvent event) {
        // Implementazione di esempio: restituisce NEUTRAL se non c'è corrispondenza con la stringa
        // Qui potresti aggiungere la logica per determinare se c'è una corrispondenza
        // Ad esempio, controllare se il messaggio dell'evento contiene una certa stringa
        // Se non c'è corrispondenza, restituisci NEUTRAL
        return NEUTRAL;
    }
}