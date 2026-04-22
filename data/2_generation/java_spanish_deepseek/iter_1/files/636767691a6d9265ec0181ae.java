import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;

public class EnumerationToStringArray {

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
        // Ejemplo de uso
        java.util.Vector<String> vector = new java.util.Vector<>();
        vector.add("Hola");
        vector.add("Mundo");
        Enumeration<String> enumeration = vector.elements();

        String[] result = toStringArray(enumeration);
        for (String s : result) {
            System.out.println(s);
        }
    }
}