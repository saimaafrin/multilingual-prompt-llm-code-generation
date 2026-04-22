import java.util.Enumeration;

public class EnumerationUtils {

    public static String[] copyEnumerationToStringArray(Enumeration<?> enumeration) {
        if (enumeration == null) {
            return null;
        }

        // Count elements in enumeration
        int count = 0;
        Enumeration<?> countEnum = enumeration;
        while (countEnum.hasMoreElements()) {
            countEnum.nextElement();
            count++;
        }

        // Create array and copy elements
        String[] array = new String[count];
        int i = 0;
        while (enumeration.hasMoreElements()) {
            Object element = enumeration.nextElement();
            if (!(element instanceof String)) {
                throw new IllegalArgumentException("Enumeration must contain String elements only");
            }
            array[i++] = (String) element;
        }
        return array;
    }
}