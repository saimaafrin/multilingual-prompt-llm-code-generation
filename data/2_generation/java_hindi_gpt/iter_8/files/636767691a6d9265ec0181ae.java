import java.util.Enumeration;
import java.util.Vector;

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

        Vector<String> vector = new Vector<>();
        while (enumeration.hasMoreElements()) {
            vector.add(enumeration.nextElement());
        }

        return vector.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example usage
        Vector<String> vector = new Vector<>();
        vector.add("Hello");
        vector.add("World");
        Enumeration<String> enumeration = vector.elements();
        
        String[] result = toStringArray(enumeration);
        for (String str : result) {
            System.out.println(str);
        }
    }
}