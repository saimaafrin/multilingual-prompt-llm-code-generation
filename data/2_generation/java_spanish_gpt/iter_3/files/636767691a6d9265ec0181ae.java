import java.util.Enumeration;
import java.util.Vector;

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

        Vector<String> vector = new Vector<>();
        while (enumeration.hasMoreElements()) {
            vector.add(enumeration.nextElement());
        }

        return vector.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Vector<String> vector = new Vector<>();
        vector.add("Elemento 1");
        vector.add("Elemento 2");
        vector.add("Elemento 3");

        Enumeration<String> enumeration = vector.elements();
        String[] result = toStringArray(enumeration);

        for (String str : result) {
            System.out.println(str);
        }
    }
}