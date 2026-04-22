import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private Map<Class<?>, Converter> registry;

    public ConverterRegistry() {
        this.registry = new HashMap<>();
    }

    /**
     * Busca y devuelve cualquier {@link Converter} registrado para la clase de destino especificada; si no hay un Converter registrado, devuelve <code>null</code>.
     * @param clazz Clase para la cual se debe devolver un Converter registrado
     * @return El {@link Converter} registrado o <code>null</code> si no se encuentra
     */
    public Converter lookup(final Class<?> clazz) {
        return registry.get(clazz);
    }

    /**
     * Registra un {@link Converter} para una clase específica.
     * @param clazz Clase para la cual se registra el Converter
     * @param converter Converter a registrar
     */
    public void register(final Class<?> clazz, final Converter converter) {
        registry.put(clazz, converter);
    }

    public static void main(String[] args) {
        ConverterRegistry registry = new ConverterRegistry();
        Converter stringConverter = new StringConverter();
        registry.register(String.class, stringConverter);

        Converter foundConverter = registry.lookup(String.class);
        if (foundConverter != null) {
            System.out.println("Converter encontrado para String");
        } else {
            System.out.println("No se encontró un Converter para String");
        }
    }
}

interface Converter {
    // Métodos de la interfaz Converter
}

class StringConverter implements Converter {
    // Implementación específica para convertir Strings
}