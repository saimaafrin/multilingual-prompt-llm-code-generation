import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;

public class EnumerationToStringArray {

    /**
     * Copia l'Enumeration fornita in un array di Stringhe. L'Enumeration deve contenere solo elementi di tipo String.
     * @param enumeration l'Enumeration da copiare
     * @return l'array di Stringhe (<code>null</code> se l'Enumeration passata era <code>null</code>)
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
        // Esempio di utilizzo
        java.util.Vector<String> vector = new java.util.Vector<>();
        vector.add("Elemento1");
        vector.add("Elemento2");
        vector.add("Elemento3");

        Enumeration<String> enumeration = vector.elements();
        String[] result = toStringArray(enumeration);

        for (String s : result) {
            System.out.println(s);
        }
    }
}