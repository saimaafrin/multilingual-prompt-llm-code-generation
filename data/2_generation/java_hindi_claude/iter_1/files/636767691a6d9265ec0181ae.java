import java.util.Enumeration;
import java.util.ArrayList;

public class EnumerationUtils {
    
    public static String[] copyEnumerationToStringArray(Enumeration<?> enumeration) {
        if (enumeration == null) {
            return null;
        }
        
        ArrayList<String> list = new ArrayList<>();
        while (enumeration.hasMoreElements()) {
            Object element = enumeration.nextElement();
            if (!(element instanceof String)) {
                throw new IllegalArgumentException("Enumeration must only contain String elements");
            }
            list.add((String) element);
        }
        
        return list.toArray(new String[0]);
    }
}