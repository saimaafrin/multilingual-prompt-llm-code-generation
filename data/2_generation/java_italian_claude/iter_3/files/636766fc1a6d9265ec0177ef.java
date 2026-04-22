import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    /**
     * Restituisce un nuovo array di Stringhe senza elementi null. Metodo interno utilizzato per normalizzare le liste di esclusione (array e collezioni). Si noti che {@link Arrays#sort(Object[])} genererà un {@link NullPointerException} se un elemento dell'array è <code>null</code>.
     * @param array L'array da controllare
     * @return L'array fornito o un nuovo array senza null.
     */
    static String[] toNoNullStringArray(Object[] array) {
        if (array == null) {
            return new String[0];
        }
        
        List<String> result = new ArrayList<>();
        for (Object obj : array) {
            if (obj != null) {
                result.add(obj.toString());
            }
        }
        
        return result.toArray(new String[0]);
    }
}