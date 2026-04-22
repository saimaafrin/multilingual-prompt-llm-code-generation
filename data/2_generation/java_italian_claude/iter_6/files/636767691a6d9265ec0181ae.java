import java.util.Enumeration;
import java.util.ArrayList;

public class EnumerationUtils {

    /**
     * Copia l'Enumeration fornita in un array di Stringhe. L'Enumeration deve contenere solo elementi di tipo String.
     * @param enumeration l'Enumeration da copiare
     * @return l'array di Stringhe (<code>null</code> se l'Enumeration passata era <code>null</code>)
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