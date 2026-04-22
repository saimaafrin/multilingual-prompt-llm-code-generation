import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {

    /**
     * Controlla se la Collection fornita contiene l'istanza dell'elemento dato. <p>Imporre che l'istanza fornita sia presente, piuttosto che restituire <code>true</code> per un elemento uguale.
     * @param collection la Collection da controllare
     * @param element l'elemento da cercare
     * @return <code>true</code> se trovato, <code>false</code> altrimenti
     */
    public static boolean containsInstance(Collection collection, Object element) {
        if (collection == null || element == null) {
            return false;
        }
        
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object current = iterator.next();
            if (current == element) {
                return true;
            }
        }
        return false;
    }
}