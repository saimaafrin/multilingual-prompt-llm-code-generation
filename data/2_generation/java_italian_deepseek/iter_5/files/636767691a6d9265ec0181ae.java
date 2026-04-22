import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;

public class EnumerationToStringArray {

    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }

        List<String> stringList = new ArrayList<>();
        while (enumeration.hasMoreElements()) {
            stringList.add(enumeration.nextElement());
        }

        return stringList.toArray(new String[0]);
    }
}