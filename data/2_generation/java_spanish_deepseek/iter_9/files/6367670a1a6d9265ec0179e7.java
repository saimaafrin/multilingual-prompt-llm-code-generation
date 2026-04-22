import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private final Map<Class<?>, Converter> registry = new HashMap<>();

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
     * @param clazz La clase para la cual se registra el Converter
     * @param converter El Converter a registrar
     */
    public void register(final Class<?> clazz, final Converter converter) {
        registry.put(clazz, converter);
    }

    // Ejemplo de clase Converter (debe ser implementada por el usuario)
    public interface Converter {
        Object convert(Object input);
    }
}