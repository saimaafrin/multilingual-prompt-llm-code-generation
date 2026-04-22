import java.util.function.Predicate;

/**
 * Invoca il {@link BroadcastFilter}
 * @param msg Il messaggio da filtrare
 * @return Il messaggio filtrato
 */
protected Object filter(Object msg) {
    // Supponiamo che BroadcastFilter sia un'interfaccia funzionale con un metodo `test`
    // che accetta un Object e restituisce un boolean.
    // Se il messaggio passa il filtro, viene restituito; altrimenti, viene restituito null.
    
    // Esempio di implementazione di un BroadcastFilter
    Predicate<Object> broadcastFilter = (message) -> {
        // Logica di filtro: ad esempio, filtrare messaggi null o vuoti
        return message != null && !message.toString().isEmpty();
    };

    // Applica il filtro al messaggio
    if (broadcastFilter.test(msg)) {
        return msg;
    } else {
        return null;
    }
}