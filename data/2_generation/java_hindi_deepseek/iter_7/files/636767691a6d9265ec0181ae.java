import java.util.Enumeration;
import java.util.ArrayList;

public class EnumerationToStringArray {

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

    public static void main(String[] args) {
        // Example usage
        java.util.Vector<String> vector = new java.util.Vector<>();
        vector.add("Hello");
        vector.add("World");
        Enumeration<String> enumeration = vector.elements();

        String[] result = toStringArray(enumeration);
        for (String str : result) {
            System.out.println(str);
        }
    }
}