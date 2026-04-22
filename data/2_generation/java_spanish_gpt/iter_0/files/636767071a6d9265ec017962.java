import org.apache.commons.beanutils.BeanMap;

public class BeanMapUtil {

    /** 
     * Coloca todas las propiedades escribibles del BeanMap dado en este BeanMap. 
     * Las propiedades de solo lectura y de solo escritura serán ignoradas.
     * @param map  el BeanMap cuyas propiedades se van a colocar
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("El BeanMap no puede ser nulo");
        }

        for (Object property : map.keySet()) {
            if (map.getPropertyType(property).isAssignableFrom(Object.class)) {
                // Ignorar propiedades de solo lectura
                if (map.isWriteable(property)) {
                    // Aquí se puede agregar la lógica para colocar la propiedad en el BeanMap actual
                    // Por ejemplo, se podría establecer un valor predeterminado o copiar el valor de otro BeanMap
                    // map.put(property, someValue); // someValue debe ser definido según la lógica deseada
                }
            }
        }
    }
}