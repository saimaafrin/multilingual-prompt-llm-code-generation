import java.util.function.Predicate;

/**
 * Invoca il {@link BroadcastFilter}
 * @param msg Il messaggio da filtrare
 * @return Il messaggio filtrato
 */
protected Object filter(Object msg) {
    // Supponiamo che BroadcastFilter sia un'interfaccia funzionale con un metodo `test`
    // che accetta un oggetto e restituisce un booleano.
    BroadcastFilter filter = new BroadcastFilter() {
        @Override
        public boolean test(Object message) {
            // Implementazione del filtro
            // Esempio: restituisce true se il messaggio non è nullo
            return message != null;
        }
    };

    // Applica il filtro al messaggio
    if (filter.test(msg)) {
        return msg; // Restituisce il messaggio se passa il filtro
    } else {
        return null; // Restituisce null se il messaggio non passa il filtro
    }
}

// Definizione dell'interfaccia BroadcastFilter
interface BroadcastFilter extends Predicate<Object> {
    // Estende Predicate<Object> per utilizzare il metodo `test`
}