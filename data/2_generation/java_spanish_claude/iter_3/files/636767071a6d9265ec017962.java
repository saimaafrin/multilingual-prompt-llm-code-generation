import org.apache.commons.beanutils.BeanMap;
import java.util.Iterator;

public class BeanMapUtils {
    
    /** 
     * Coloca todas las propiedades escribibles del BeanMap dado en este BeanMap. 
     * Las propiedades de solo lectura y de solo escritura serán ignoradas.
     * @param map el BeanMap cuyas propiedades se van a colocar
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            return;
        }

        Iterator<?> entries = map.entryIterator();
        while (entries.hasNext()) {
            BeanMap.Entry entry = (BeanMap.Entry) entries.next();
            String propertyName = entry.getKey().toString();
            
            // Verifica si la propiedad es escribible en ambos BeanMaps
            if (map.isWriteable(propertyName) && this.isWriteable(propertyName)) {
                Object value = entry.getValue();
                this.put(propertyName, value);
            }
        }
    }
}