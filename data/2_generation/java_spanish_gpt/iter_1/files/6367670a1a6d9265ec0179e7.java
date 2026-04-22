import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private Map<Class<?>, Converter> converterMap = new HashMap<>();

    /**
     * Busca y devuelve cualquier {@link Converter} registrado para la clase de destino especificada; si no hay un Converter registrado, devuelve <code>null</code>.
     * @param clazz Clase para la cual se debe devolver un Converter registrado
     * @return El {@link Converter} registrado o <code>null</code> si no se encuentra
     */
    public Converter lookup(final Class<?> clazz) {
        return converterMap.get(clazz);
    }

    public void registerConverter(Class<?> clazz, Converter converter) {
        converterMap.put(clazz, converter);
    }

    public interface Converter {
        // Define methods for the Converter interface
    }
}