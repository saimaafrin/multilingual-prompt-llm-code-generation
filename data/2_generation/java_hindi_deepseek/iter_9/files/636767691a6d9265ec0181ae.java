import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;

public class EnumerationToStringArray {

    /**
     * दिए गए Enumeration को एक String array में कॉपी करें। Enumeration में केवल String तत्व होने चाहिए।
     * @param enumeration कॉपी करने के लिए Enumeration
     * @return String array (<code>null</code> यदि पास किया गया Enumeration <code>null</code> था)
     */
    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }

        List<String> list = new ArrayList<>();
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