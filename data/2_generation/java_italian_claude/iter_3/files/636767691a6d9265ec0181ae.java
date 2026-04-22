import java.util.Enumeration;

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

        // Count elements in enumeration
        int size = 0;
        Enumeration<String> counter = enumeration;
        while (counter.hasMoreElements()) {
            counter.nextElement();
            size++;
        }

        // Create array and copy elements
        String[] array = new String[size];
        int index = 0;
        while (enumeration.hasMoreElements()) {
            array[index++] = enumeration.nextElement();
        }

        return array;
    }
}