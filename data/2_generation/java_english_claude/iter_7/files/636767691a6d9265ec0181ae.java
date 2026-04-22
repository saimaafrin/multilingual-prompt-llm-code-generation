import java.util.Enumeration;
import java.util.ArrayList;

public class EnumerationUtils {

    /**
     * Copy the given Enumeration into a String array. The Enumeration must contain String elements only.
     * @param enumeration the Enumeration to copy
     * @return the String array (<code>null</code> if the passed-in Enumeration was <code>null</code>)
     */
    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }

        ArrayList<String> list = new ArrayList<>();
        while (enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }
        
        return list.toArray(new String[0]);
    }
}