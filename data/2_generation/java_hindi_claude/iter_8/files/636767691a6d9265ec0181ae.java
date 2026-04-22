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
            if (element instanceof String) {
                list.add((String) element);
            } else {
                throw new ClassCastException("Enumeration must contain String elements only");
            }
        }
        
        return list.toArray(new String[0]);
    }
}