import java.util.HashMap;
import java.util.Map;

interface Converter {
    // Define the methods that a Converter should implement
    Object convert(Object source);
}

public class ConverterRegistry {
    private final Map<Class<?>, Converter> converterMap = new HashMap<>();

    /**
     * Busca y devuelve cualquier {@link Converter} registrado para la clase de destino especificada; si no hay un Converter registrado, devuelve <code>null</code>.
     * @param clazz Clase para la cual se debe devolver un Converter registrado
     * @return El {@link Converter} registrado o <code>null</code> si no se encuentra
     */
    public Converter lookup(final Class<?> clazz) {
        return converterMap.get(clazz);
    }

    // Método para registrar un Converter
    public void registerConverter(Class<?> clazz, Converter converter) {
        converterMap.put(clazz, converter);
    }
}