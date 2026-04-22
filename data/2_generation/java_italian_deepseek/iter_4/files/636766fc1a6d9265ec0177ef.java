import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    /**
     * Restituisce un nuovo array di Stringhe senza elementi null. Metodo interno utilizzato per normalizzare le liste di esclusione (array e collezioni). Si noti che {@link Arrays#sort(Object[])} genererà un {@link NullPointerException} se un elemento dell'array è <code>null</code>.
     * @param array L'array da controllare
     * @return L'array fornito o un nuovo array senza null.
     */
    static String[] toNoNullStringArray(Object[] array) {
        if (array == null) {
            return new String[0];
        }

        List<String> nonNullList = new ArrayList<>();
        for (Object element : array) {
            if (element != null) {
                nonNullList.add(element.toString());
            }
        }

        return nonNullList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        Object[] testArray = { "Hello", null, "World", null, "Java" };
        String[] result = toNoNullStringArray(testArray);

        for (String str : result) {
            System.out.println(str);
        }
    }
}