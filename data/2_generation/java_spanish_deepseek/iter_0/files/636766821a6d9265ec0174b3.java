import java.util.function.Function;

/**
 * Invoca el {@link BroadcastFilter}
 * @param msg El mensaje que se desea filtrar.
 * @return El resultado de aplicar el filtro al mensaje.
 */
protected Object filter(Object msg) {
    // Asumiendo que BroadcastFilter es una interfaz funcional que toma un Object y devuelve un Object
    BroadcastFilter filter = new BroadcastFilter() {
        @Override
        public Object apply(Object input) {
            // Implementación del filtro
            // Aquí puedes agregar la lógica de filtrado
            return input; // Por defecto, devuelve el mismo mensaje
        }
    };

    return filter.apply(msg);
}

// Definición de la interfaz BroadcastFilter
interface BroadcastFilter extends Function<Object, Object> {
    // La interfaz puede tener métodos adicionales si es necesario
}