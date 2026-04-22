import java.util.function.Predicate;

/**
 * Invoca il {@link BroadcastFilter}
 * @param msg L'oggetto da filtrare
 * @return L'oggetto filtrato o null se non supera il filtro
 */
protected Object filter(Object msg) {
    // Esempio di implementazione di un filtro
    Predicate<Object> broadcastFilter = obj -> {
        // Logica di filtro personalizzata
        return obj != null; // Esempio: filtra solo oggetti non nulli
    };

    if (broadcastFilter.test(msg)) {
        return msg;
    } else {
        return null;
    }
}