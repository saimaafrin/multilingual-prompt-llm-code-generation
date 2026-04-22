import org.apache.commons.beanutils.BeanMap;
import java.util.Iterator;

public class BeanMapUtils {
    
    /**
     * Inserisce tutte le proprietà scrivibili dal BeanMap fornito in questo BeanMap. 
     * Le proprietà di sola lettura e di sola scrittura verranno ignorate.
     * @param map il BeanMap le cui proprietà devono essere inserite
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            return;
        }

        Iterator<?> it = map.keyIterator();
        while (it.hasNext()) {
            String propertyName = (String) it.next();
            
            // Verifica se la proprietà è scrivibile
            if (map.getWriteMethod(propertyName) != null) {
                Object value = map.get(propertyName);
                try {
                    // Inserisce solo se esiste un metodo setter
                    if (this.getWriteMethod(propertyName) != null) {
                        this.put(propertyName, value);
                    }
                } catch (Exception e) {
                    // Ignora le proprietà che non possono essere scritte
                    continue;
                }
            }
        }
    }
}