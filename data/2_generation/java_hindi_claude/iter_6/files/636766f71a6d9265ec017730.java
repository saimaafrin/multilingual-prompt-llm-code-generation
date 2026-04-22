import java.util.Collection;
import java.util.ArrayList;

public class CollectionConverter {
    
    public static String[] toStringArray(Collection<?> collection) {
        if (collection == null) {
            return new String[0];
        }
        
        ArrayList<String> list = new ArrayList<>();
        
        for (Object obj : collection) {
            if (obj != null) {
                list.add(obj.toString());
            }
        }
        
        return list.toArray(new String[0]);
    }
}