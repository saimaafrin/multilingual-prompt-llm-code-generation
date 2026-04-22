import java.util.Arrays;

public class ArrayUtils {

    /**
     * Aggiunge la Stringa fornita all'array di Stringhe dato, restituendo un nuovo array che consiste nei contenuti dell'array di input più la Stringa fornita.
     * @param array l'array a cui aggiungere (può essere <code>null</code>)
     * @param str la Stringa da aggiungere
     * @return il nuovo array (mai <code>null</code>)
     */
    public static String[] addStringToArray(String[] array, String str) {
        if (array == null) {
            return new String[]{str};
        }
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = str;
        return newArray;
    }

    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        String[] newArray = addStringToArray(array, "d");
        System.out.println(Arrays.toString(newArray)); // Output: [a, b, c, d]
    }
}