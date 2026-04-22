import java.util.HashMap;
import java.util.Map;

public class MessageLogger {
    private Map<String, Integer> messageTimestamps;

    public MessageLogger() {
        messageTimestamps = new HashMap<>();
    }

    /**
     * Devuelve "true" si el mensaje debe imprimirse en la tiempo dada, de lo contrario devuelve falso.
     * Si este método devuelve falso, el mensaje no se imprimirá. El tiempo está en segundos.
     *
     * @param timestamp El tiempo actual en segundos.
     * @param message El mensaje que se desea imprimir.
     * @return true si el mensaje debe imprimirse, false en caso contrario.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messageTimestamps.containsKey(message)) {
            int lastTimestamp = messageTimestamps.get(message);
            if (timestamp - lastTimestamp >= 10) {
                messageTimestamps.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            messageTimestamps.put(message, timestamp);
            return true;
        }
    }
}