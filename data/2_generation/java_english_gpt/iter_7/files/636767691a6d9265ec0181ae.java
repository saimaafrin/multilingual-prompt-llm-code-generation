import java.util.Enumeration;
import java.util.Vector;

public class EnumerationToStringArray {

    /** 
     * Copy the given Enumeration into a String array. The Enumeration must contain String elements only.
     * @param enumeration the Enumeration to copy
     * @return the String array (<code>null</code> if the passed-in Enumeration was <code>null</code>)
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