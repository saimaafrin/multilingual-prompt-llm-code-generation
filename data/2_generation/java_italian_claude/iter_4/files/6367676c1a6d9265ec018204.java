import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    /**
     * Concatenare i dati degli array di Stringa forniti in uno solo, includendo gli elementi sovrapposti due volte.
     * L'ordine degli elementi negli array originali è preservato.
     * @param array1 il primo array (può essere <code>null</code>)
     * @param array2 il secondo array (può essere <code>null</code>) 
     * @return il nuovo array (<code>null</code> se entrambi gli array forniti erano <code>null</code>)
     */
    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        // Return null if both arrays are null
        if (array1 == null && array2 == null) {
            return null;
        }
        
        // Create list to store concatenated elements
        List<String> result = new ArrayList<>();
        
        // Add elements from first array if not null
        if (array1 != null) {
            for (String s : array1) {
                result.add(s);
            }
        }
        
        // Add elements from second array if not null
        if (array2 != null) {
            for (String s : array2) {
                result.add(s);
            }
        }
        
        // Convert list to array and return
        return result.toArray(new String[0]);
    }
}