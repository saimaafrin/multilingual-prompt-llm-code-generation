import java.util.function.Predicate;

/**
 * Invoca el {@link BroadcastFilter}
 * @param msg el mensaje a filtrar
 * @return el mensaje filtrado o null si no pasa el filtro
 */
protected Object filter(Object msg) {
    // Asumimos que BroadcastFilter es una interfaz funcional similar a Predicate
    BroadcastFilter filter = new BroadcastFilter() {
        @Override
        public boolean test(Object message) {
            // Lógica de filtrado personalizada
            return message != null; // Ejemplo simple: filtrar mensajes no nulos
        }
    };

    // Aplicar el filtro
    if (filter.test(msg)) {
        return msg;
    } else {
        return null;
    }
}

// Definición de la interfaz BroadcastFilter
interface BroadcastFilter extends Predicate<Object> {
    // Puede incluir métodos adicionales si es necesario
}