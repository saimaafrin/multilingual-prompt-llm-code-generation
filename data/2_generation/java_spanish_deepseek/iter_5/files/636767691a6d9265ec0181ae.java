import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;

public class EnumerationToStringArray {

    /**
     * Copia el "Enumeration" dado en un arreglo de String. El "Enumeration" debe contener solo elementos de tipo String.
     * @param enumeration El "Enumeration" a copiar
     * @return el arreglo de Strings (<code>null</code> si El "Enumeration" pasada era <code>null</code>)
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
}