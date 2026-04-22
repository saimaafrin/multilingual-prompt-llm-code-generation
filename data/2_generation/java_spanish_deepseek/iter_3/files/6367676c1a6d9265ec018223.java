import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {

    /**
     * Verifica si la colección dada contiene la instancia del elemento proporcionado. <p>Exige que la instancia dada esté presente, en lugar de devolver <code>true</code> para un elemento igual también.
     * @param collection la colección a verificar
     * @param element el elemento a buscar
     * @return <code>true</code> si se encuentra, <code>false</code> en caso contrario
     */
    public static boolean containsInstance(Collection<?> collection, Object element) {
        if (collection == null || element == null) {
            return false;
        }
        
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object current = iterator.next();
            if (current == element) {
                return true;
            }
        }
        return false;
    }
}